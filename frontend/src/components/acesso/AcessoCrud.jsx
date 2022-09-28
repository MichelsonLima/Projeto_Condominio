import React, { Component } from "react"
import axios from 'axios'
import Main from '../template/main'

const headerProps = {
    icon: 'product-hunt',
    title: 'Acessos',
    subtitle: "Cadastro de acessos"
}

const baseUrl = 'http://localhost:8080/acessos'

// Criado para cada vez que criar uma requisição, vai zerar os campos.
const initState= {
    acesso: { dataInicial: '', dataFinal: '', sistemaDeGaragem: '', reserva: '', visitante: ''},
    list: []
}

export default class AcessoCrud extends Component {
    
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
        this.setState({ acesso: initState.acesso })
    }

    save() {
        const acesso = this.state.acesso; 
        const method = acesso.id ? 'put' : 'post';
        const url = acesso.id ? `${baseUrl}/${acesso.id}` : baseUrl;
        axios[method](url,acesso).then(resp => {
            //resp.data é a resposta do backend, o que retornar de resposta
            //vamos jogar para a função getUpdatedList
            const list = this.getUpdatedList(resp.data);
            this.setState({ acesso: initState.acesso, list });         
        });
    }

    getUpdatedList(acesso, add = true){      
        const list = this.state.list.filter(p => p.id !== acesso.id);
              if(add) list.unshift(acesso); 
    }

    updatefield(event) {
        const acesso = { ... this.state.acesso }
        acesso[event.target.name] = event.target.value /**em target pegamos o conteúdo de input name */
        this.setState({ acesso })
    }

    renderForm(){
        /**jsx que ira renderizar o formulário */
        return (
            <div className="form">
                <div className="row">
                    
                    
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>dataInicial</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="dataInicial" 
                                value={this.state.acesso.dataInicial}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite a data inicial."
                            />
                        </div>
                    </div>
                    
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>dataFinal</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="dataFinal" 
                                value={this.state.acesso.dataFinal}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite a data final."
                            />
                        </div>
                    </div>
                   
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>sistemaDeGaragem</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="sistemaDeGaragem" 
                                value={this.state.acesso.sistemaDeGaragem}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite a vaga de garagem"
                            />
                        </div>
                    </div>
                    
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>reserva</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="reserva" 
                                value={this.state.acesso.reserva}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite a reserva."
                            />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>visitante</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="visitante" 
                                value={this.state.acesso.visitante}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite o visitante."
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

    load(acesso){
        this.setState({ acesso })/**atualiza o estado da aplicação. */
    }

    remove(acesso){
        axios.delete(`${baseUrl}/${acesso.id}`).then(resp => {
            const list = this.getUpdatedList(acesso, false)
            this.setState({ list })
        })
    }

    renderTable(){
        return(
            <table className="table mt-4">
               <thead>
                    <tr>
                        <th>Data inicial</th>
                        <th>Data final</th>
                        <th>Sistema de garagem</th>
                        <th>Reserva</th>
                        <th>Visitante</th>
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
        return this.state.list.map(acesso => {
            return (                
                <tr key={acesso.id}>
                    <td>{acesso.dataInicial}</td>
                    <td>{acesso.dataFinal}</td>
                    <td>{acesso.sistemaDeGaragem}</td>
                    <td>{acesso.reserva}</td>
                    <td>{acesso.visitante}</td>
                    <td>
                        <button className="btn btn-warning"
                        onClick={() => this.load(acesso)}>
                            <i className="fa fa-pencil"></i>
                        </button>
                        <button className="btn btn-danger ml-2"
                        onClick={() => this.remove(acesso)}>
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