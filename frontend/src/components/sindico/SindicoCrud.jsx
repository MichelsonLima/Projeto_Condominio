import React, { Component } from "react"
import axios from 'axios'
import Main from '../template/main'

const headerProps = {
    icon: 'user',
    title: 'Síndicos',
    subtitle: "Cadastro de Síndicos"
}

const baseUrl = 'http://localhost:8080/sindicos'

// Criado para cada vez que criar uma requisição, vai zerar os campos.
const initState= {
    sindico: { nome: '', endereco: '', telefone: '', cpf: '', rg: ''},
    list: []
}

export default class SindicoCrud extends Component {
    
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
        this.setState({ sindico: initState.sindico })
    }

    save() {
        const sindico = this.state.sindico; 
        const method = sindico.id ? 'put' : 'post';
        const url = sindico.id ? `${baseUrl}/${sindico.id}` : baseUrl;
        axios[method](url,sindico).then(resp => {
            //resp.data é a resposta do backend, o que retornar de resposta
            //vamos jogar para a função getUpdatedList
            const list = this.getUpdatedList(resp.data);
            this.setState({ sindico: initState.sindico, list });         
        });
    }

    getUpdatedList(sindico, add = true){      
        const list = this.state.list.filter(p => p.id !== sindico.id);
        if(add) list.unshift(sindico); /**inserindo na primeira posição do array */
        return list;
    }

    updatefield(event) {
        const sindico = { ... this.state.sindico }
        sindico[event.target.name] = event.target.value /**em target pegamos o conteúdo de input name */
        this.setState({ sindico })
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
                                value={this.state.sindico.nome}
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
                                value={this.state.sindico.endereco}
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
                                value={this.state.sindico.telefone}
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
                                value={this.state.sindico.cpf}
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
                                value={this.state.sindico.rg}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite o rg."
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

    load(sindico){
        this.setState({ sindico })/**atualiza o estado da aplicação. */
    }

    remove(sindico){
        axios.delete(`${baseUrl}/${sindico.id}`).then(resp => {
            const list = this.getUpdatedList(sindico, false)
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
        return this.state.list.map(sindico => {
            return (                
                <tr key={sindico.id}>
                    <td>{sindico.id}</td>
                    <td>{sindico.nome}</td>
                    <td>{sindico.endereco}</td>
                    <td>{sindico.telefone}</td>
                    <td>{sindico.cpf}</td>
                    <td>{sindico.rg}</td>
                    <td>
                        <button className="btn btn-warning"
                        onClick={() => this.load(sindico)}>
                            <i className="fa fa-pencil"></i>
                        </button>
                        <button className="btn btn-danger ml-2"
                        onClick={() => this.remove(sindico)}>
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