import React, { Component } from "react"
import axios from 'axios'
import Main from '../template/main'

const headerProps = {
    icon: 'user',
    title: 'Prestador de Servicos',
    subtitle: "Cadastro de prestador de servicos"
}

const baseUrl = 'http://localhost:8080/prestadoresDeServicos'

// Criado para cada vez que criar uma requisição, vai zerar os campos.
const initState= {
    prestadorDeServico: { nome: '', endereco: '', telefone: '', tipoServico: '', tipoJuridicaOuFisica: '', cfpOuCnpj: '', condomino_id: ''},
    list: []
}

export default class PrestadorDeServicoCrud extends Component {
    
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
        this.setState({ prestadorDeServico: initState.prestadorDeServico })
    }

    save() {
        const prestadorDeServico = this.state.prestadorDeServico; 
        const method = prestadorDeServico.id ? 'put' : 'post';
        const url = prestadorDeServico.id ? `${baseUrl}/${prestadorDeServico.id}` : baseUrl;
        axios[method](url,prestadorDeServico).then(resp => {
            //resp.data é a resposta do backend, o que retornar de resposta
            //vamos jogar para a função getUpdatedList
            const list = this.getUpdatedList(resp.data);
            this.setState({ prestadorDeServico: initState.prestadorDeServico, list });         
        });
    }

    getUpdatedList(prestadorDeServico, add = true){      
        const list = this.state.list.filter(p => p.id !== prestadorDeServico.id); 
        if(add) list.unshift(prestadorDeServico);
        return list;
    }

    updatefield(event) {
        const prestadorDeServico = { ... this.state.prestadorDeServico }
        prestadorDeServico[event.target.name] = event.target.value /**em target pegamos o conteúdo de input name */
        this.setState({ prestadorDeServico })
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
                                value={this.state.prestadorDeServico.nome}
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
                                value={this.state.prestadorDeServico.endereco}
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
                                value={this.state.prestadorDeServico.telefone}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite o telefone."
                            />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>tipoServico</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="tipoServico" 
                                value={this.state.prestadorDeServico.tipoServico}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite o tipo de serviço."
                            />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>tipoJuridicaOuFisica</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="tipoJuridicaOuFisica" 
                                value={this.state.prestadorDeServico.tipoJuridicaOuFisica}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite tipo Juridica Ou Fisica."
                            />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>cfpOuCnpj</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="cfpOuCnpj" 
                                value={this.state.prestadorDeServico.cfpOuCnpj}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite cfp Ou Cnpj."
                            />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>condomino_id</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="condomino_id" 
                                value={this.state.prestadorDeServico.condomino_id}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite condomino_id."
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

    load(prestadorDeServico){
        this.setState({ prestadorDeServico })/**atualiza o estado da aplicação. */
    }

    remove(prestadorDeServico){
        axios.delete(`${baseUrl}/${prestadorDeServico.id}`).then(resp => {
            const list = this.getUpdatedList(prestadorDeServico, false)
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
                        <th>tipoServico</th>
                        <th>tipoJuridicaOuFisica</th>
                        <th>cfpOuCnpj</th>
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
        /**mapeando usuários que estão no estado do objeto */
        //Toda vez que passa faz o map, precisa-se passar no primeiro elemento
        //o key, valor único que serve para identificar cada um dos elementos
        return this.state.list.map(prestadorDeServico => {
            return (                
                <tr key={prestadorDeServico.id}>
                    <td>{prestadorDeServico.id}</td>
                    <td>{prestadorDeServico.nome}</td>
                    <td>{prestadorDeServico.endereco}</td>
                    <td>{prestadorDeServico.telefone}</td>
                    <td>{prestadorDeServico.tipoServico}</td>
                    <td>{prestadorDeServico.tipoJuridicaOuFisica}</td>
                    <td>{prestadorDeServico.cfpOuCnpj}</td>
                    <td>{prestadorDeServico.condomino_id}</td>
                    <td>
                        <button className="btn btn-warning"
                        onClick={() => this.load(prestadorDeServico)}>
                            <i className="fa fa-pencil"></i>
                        </button>
                        <button className="btn btn-danger ml-2"
                        onClick={() => this.remove(prestadorDeServico)}>
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