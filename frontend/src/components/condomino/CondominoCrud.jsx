import React, { Component } from "react"
import axios from 'axios'
import Main from '../template/main'

const headerProps = {
    icon: 'user',
    title: 'Condôminos',
    subtitle: "Cadastro de condôminos"
}

const baseUrl = 'http://localhost:8080/condominos'

// Criado para cada vez que criar uma requisição, vai zerar os campos.
const initState= {
    condomino: { nome: '', endereco: '', telefone: '', cpf: '', rg: '', unidade: ''},
    list: []
}

export default class CondominoCrud extends Component {
    
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
        this.setState({ condomino: initState.condomino })
    }

    save() {
        const condomino = this.state.condomino; 
        const method = condomino.id ? 'put' : 'post';
        const url = condomino.id ? `${baseUrl}/${condomino.id}` : baseUrl;
        axios[method](url,condomino).then(resp => {
            //resp.data é a resposta do backend, o que retornar de resposta
            //vamos jogar para a função getUpdatedList
            const list = this.getUpdatedList(resp.data);
            this.setState({ condomino: initState.condomino, list });         
        });
    }

    getUpdatedList(condomino, add = true){      
        const list = this.state.list.filter(p => p.id !== condomino.id); 
        if(add) list.unshift(condomino); /**inserindo na primeira posição do array */
        return list;
    }

    updatefield(event) {
        const condomino = { ... this.state.condomino }
        condomino[event.target.name] = event.target.value /**em target pegamos o conteúdo de input name */
        this.setState({ condomino })
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
                                value={this.state.condomino.nome}
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
                                value={this.state.condomino.endereco}
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
                                value={this.state.condomino.telefone}
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
                                value={this.state.condomino.cpf}
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
                                value={this.state.condomino.rg}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite o rg."
                            />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>unidade</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="unidade" 
                                value={this.state.condomino.unidade}
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

    load(condomino){
        this.setState({ condomino })/**atualiza o estado da aplicação. */
    }

    remove(condomino){
        axios.delete(`${baseUrl}/${condomino.id}`).then(resp => {
            const list = this.getUpdatedList(condomino, false)
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
                        <th>Unidade</th>
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
        /**mapeando usuários que estão no estado do objeto */
        //Toda vez que passa faz o map, precisa-se passar no primeiro elemento
        //o key, valor único que serve para identificar cada um dos elementos
        return this.state.list.map(condomino => {
            return (                
                <tr key={condomino.id}>
                    <td>{condomino.id}</td>
                    <td>{condomino.nome}</td>
                    <td>{condomino.endereco}</td>
                    <td>{condomino.telefone}</td>
                    <td>{condomino.cpf}</td>
                    <td>{condomino.rg}</td>
                    <td>{condomino.unidade}</td>
                    <td>
                        <button className="btn btn-warning"
                        onClick={() => this.load(condomino)}>
                            <i className="fa fa-pencil"></i>
                        </button>
                        <button className="btn btn-danger ml-2"
                        onClick={() => this.remove(condomino)}>
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