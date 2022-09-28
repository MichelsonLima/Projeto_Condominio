import React, { Component } from "react"
import axios from 'axios'
import Main from '../template/main'

const headerProps = {
    icon: 'users',
    title: 'Famílias',
    subtitle: "Cadastro de famílias"
}

const baseUrl = 'http://localhost:8080/familias'

// Criado para cada vez que criar uma requisição, vai zerar os campos.
const initState= {
   
    familia: { nome: '', endereco: '', telefone: '', cpf: '', rg: '', grauParentesco: '', condomino: ''},
    list: []
}

export default class FamiliaCrud extends Component {
    
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
        this.setState({ familia: initState.familia })
    }

    save() {
        const familia = this.state.familia; 
        const method = familia.id ? 'put' : 'post';
        const url = familia.id ? `${baseUrl}/${familia.id}` : baseUrl;
        axios[method](url,familia).then(resp => {
            //resp.data é a resposta do backend, o que retornar de resposta
            //vamos jogar para a função getUpdatedList
            const list = this.getUpdatedList(resp.data);
            this.setState({ familia: initState.familia, list });         
        });
    }

    getUpdatedList(familia, add = true){      
        const list = this.state.list.filter(p => p.id !== familia.id);
        if(add) list.unshift(familia); /**inserindo na primeira posição do array */
        return list;
    }

    updatefield(event) {
        const familia = { ... this.state.familia }
        familia[event.target.name] = event.target.value /**em target pegamos o conteúdo de input name */
        this.setState({ familia })
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
                                value={this.state.familia.nome}
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
                                value={this.state.familia.endereco}
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
                                value={this.state.familia.telefone}
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
                                value={this.state.familia.cpf}
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
                                value={this.state.familia.rg}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite o rg."
                            />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Grau de parentesco</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="grauParentesco" 
                                value={this.state.familia.grauParentesco}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite o Grau de parentesco."
                            />
                        </div>
                    </div>
                   
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Id do condômino</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="condomino" 
                                value={this.state.familia.condomino.id}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite o Id do condômino."
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

    load(familia){
        this.setState({ familia })/**atualiza o estado da aplicação. */
    }

    remove(familia){
        axios.delete(`${baseUrl}/${familia.id}`).then(resp => {
            const list = this.getUpdatedList(familia, false)
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
                        <th>grauParentesco</th>
                        <th>Condômino</th>
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
        return this.state.list.map(familia => {
            return (                
                <tr key={familia.id}>
                    <td>{familia.id}</td>
                    <td>{familia.nome}</td>
                    <td>{familia.endereco}</td>
                    <td>{familia.telefone}</td>
                    <td>{familia.cpf}</td>
                    <td>{familia.rg}</td>
                    <td>{familia.grauParentesco}</td>
                    <td>{familia.condomino.id}</td>
                    <td>
                        <button className="btn btn-warning"
                        onClick={() => this.load(familia)}>
                            <i className="fa fa-pencil"></i>
                        </button>
                        <button className="btn btn-danger ml-2"
                        onClick={() => this.remove(familia)}>
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