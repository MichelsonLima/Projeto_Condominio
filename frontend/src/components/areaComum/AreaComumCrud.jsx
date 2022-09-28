import React, { Component } from "react"
import axios from 'axios'
import Main from '../template/main'

const headerProps = {
    icon: 'product-hunt',
    title: 'Áreas comuns',
    subtitle: "Cadastro de área comum"
}

const baseUrl = 'http://localhost:8080/areasComuns'

// Criado para cada vez que criar uma requisição, vai zerar os campos.
const initState= {
       areaComum: { nome: '', reserva: ''},
    list: []
}

export default class AreaComumCrud extends Component {
    
    state = { ...initState }

    /**Chamada quando o elemento for exibido na tela */
    //vai ser chamado toda vez que montar o component, essa função vai ser a primeira a rodar
    componentWillMount() {
        axios(baseUrl, {
            crossdomain: true,
            credentials: 'same-Origin'
        })
        .then(resp => {
            this.setState({ list: resp.data })/**salvamos dentro da lista as requisições */  
        })        
    }

      /*Limpar formulario */
    clear() {
        this.setState({ areaComum: initState.areaComum })
    }

    save() {
        const areaComum = this.state.areaComum; 
        const method = areaComum.id ? 'put' : 'post';
        const url = areaComum.id ? `${baseUrl}/${areaComum.id}` : baseUrl;
        axios[method](url,areaComum).then(resp => {
            //resp.data é a resposta do backend, o que retornar de resposta
            //vamos jogar para a função getUpdatedList
            const list = this.getUpdatedList(resp.data);
            this.setState({ areaComum: initState.areaComum, list });         
        });
    }

    getUpdatedList(areaComum, add = true){      
        const list = this.state.list.filter(p => p.id !== areaComum.id); 
        if(add) list.unshift(areaComum); /**inserindo na primeira posição do array */
        return list;
    }

    updatefield(event) {
        const areaComum = { ... this.state.areaComum }
        areaComum[event.target.name] = event.target.value /**em target pegamos o conteúdo de input name */
        this.setState({ areaComum })
    }

    renderForm(){
        /**jsx que ira renderizar o formulário */
        return (
            <div className="form">
                <div className="row">
                    
                    
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Nome</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="nome" 
                                value={this.state.areaComum.nome}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite a área em comum."
                            />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Reserva</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="reserva" 
                                value={this.state.areaComum.reserva}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite a reserva."
                            />
                        </div>
                    </div>
     
                </div>

                <hr />
                <div className="row">
                    <div className="col-12 d-flex justify-content end">
                        <button className="btn btn-primary"
                        onClick={e => this.save(e)}>Salvar</button>
                        <button className="btn btn-secondary ml-2"
                        onClick={e => this.clear(e)}>Cancelar</button>
                    </div>
                </div>
            </div>
        );
    }

    load(areaComum){
        this.setState({ areaComum })/**atualiza o estado da aplicação. */
    }

    remove(areaComum){
        axios.delete(`${baseUrl}/${areaComum.id}`).then(resp => {
            const list = this.getUpdatedList(areaComum, false)
            this.setState({ list })
        })
    }

    renderTable(){
        return(
            <table className="table mt-4">
               <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Reserva</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    {this.renderows()}
                </tbody>            
            </table>
        );
    }

    renderows(){
        return this.state.list.map(areaComum => {
            return (                
                <tr key={areaComum.id}>
                    <td>{areaComum.id}</td>
                    <td>{areaComum.nome}</td>
                    <td>{areaComum.reserva}</td>   
                    <td>
                        <button className="btn btn-warning"
                        onClick={() => this.load(areaComum)}>
                            <i className="fa fa-pencil"></i>
                        </button>
                        <button className="btn btn-danger ml-2"
                        onClick={() => this.remove(areaComum)}>
                            <i className="fa fa-trash"></i>
                        </button>
                    </td>
                </tr>
            );
        });
    }

    render(){        
        return(            
            <Main {... headerProps}>                
                {this.renderForm()}
                {this.renderTable()}
            </Main>
        );
    }
}