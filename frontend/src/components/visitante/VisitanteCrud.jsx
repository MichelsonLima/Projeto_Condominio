import React, { Component } from "react"
import axios from 'axios'
import Main from '../template/main'

const headerProps = {
    icon: 'user',
    title: 'Visitantes',
    subtitle: "Cadastro de visitantes"
}

const baseUrl = 'http://localhost:8080/visitantes'

// Criado para cada vez que criar uma requisição, vai zerar os campos.
const initState= {
    visitante: { nome: '', endereco: '', telefone: '', cpf: '', rg: '', unidade: '', condomino_id: ''},
    list: []
}

export default class VisitanteCrud extends Component {
    
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
        this.setState({ visitante: initState.visitante })
    }

    save() {
        const visitante = this.state.visitante; 
        const method = visitante.id ? 'put' : 'post';
        const url = visitante.id ? `${baseUrl}/${visitante.id}` : baseUrl;
        axios[method](url,visitante).then(resp => {
            //resp.data é a resposta do backend, o que retornar de resposta
            //vamos jogar para a função getUpdatedList
            const list = this.getUpdatedList(resp.data);
            this.setState({ visitante: initState.visitante, list });         
        });
    }

    getUpdatedList(visitante, add = true){      
        const list = this.state.list.filter(p => p.id !== visitante.id); 
        if(add) list.unshift(visitante); /**inserindo na primeira posição do array */
        return list;
    }

    updatefield(event) {
        const visitante = { ... this.state.visitante }
        visitante[event.target.name] = event.target.value /**em target pegamos o conteúdo de input name */
        this.setState({ visitante })
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
                                value={this.state.visitante.nome}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite o nome."
                            />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Endereco</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="endereco" 
                                value={this.state.visitante.endereco}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite o endereco."
                            />
                        </div>
                    </div>
                   
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>telefone</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="telefone" 
                                value={this.state.visitante.telefone}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite o telefone."
                            />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>cpf</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="cpf" 
                                value={this.state.visitante.cpf}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite o cpf."
                            />
                        </div>
                    </div>
                    
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>rg</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="rg" 
                                value={this.state.visitante.rg}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite o rg."
                            />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>condomino_id</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="unidade" 
                                value={this.state.visitante.unidade}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite a unidade."
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

    load(visitante){
        this.setState({ visitante })/**atualiza o estado da aplicação. */
    }

    remove(visitante){
        axios.delete(`${baseUrl}/${visitante.id}`).then(resp => {
            const list = this.getUpdatedList(visitante, false)
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
                        <th>Endereço</th>
                        <th>Telefone</th>
                        <th>CPF</th>
                        <th>RG</th>
                        <th>condomino_id</th>
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
        //Toda vez que passa faz o map, precisa-se passar no primeiro elemento
        //o key, valor único que serve para identificar cada um dos elementos
        return this.state.list.map(visitante => {
            return (                
                <tr key={visitante.id}>
                    <td>{visitante.id}</td>
                    <td>{visitante.nome}</td>
                    <td>{visitante.endereco}</td>
                    <td>{visitante.telefone}</td>
                    <td>{visitante.cpf}</td>
                    <td>{visitante.rg}</td>
                    <td>{visitante.condomino_id}</td>
                    <td>
                        <button className="btn btn-warning"
                        onClick={() => this.load(visitante)}>
                            <i className="fa fa-pencil"></i>
                        </button>
                        <button className="btn btn-danger ml-2"
                        onClick={() => this.remove(visitante)}>
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