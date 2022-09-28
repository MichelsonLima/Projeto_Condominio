import React, { Component } from "react"
import axios from 'axios'
import Main from '../template/main'

const headerProps = {
    icon: 'product-hunt',
    title: 'Reservas',
    subtitle: "Agendamento de reservas"
}

const baseUrl = 'http://localhost:8080/reservas'

// Criado para cada vez que criar uma requisição, vai zerar os campos.
const initState= {
    reserva: { dataInicio: '', dataFim: '', acesso: '', areaComum: '', condomino: '', sistemaDeGaragem: ''},
    list: []
}

export default class ReservaCrud extends Component {
    
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
        this.setState({ reserva: initState.reserva })
    }

    save() {
        const reserva = this.state.reserva; 
        const method = reserva.id ? 'put' : 'post';
        const url = reserva.id ? `${baseUrl}/${reserva.id}` : baseUrl;
        axios[method](url,reserva).then(resp => {
            //resp.data é a resposta do backend, o que retornar de resposta
            //vamos jogar para a função getUpdatedList
            const list = this.getUpdatedList(resp.data);
            this.setState({ reserva: initState.reserva, list });         
        });
    }

    getUpdatedList(reserva, add = true){      
        const list = this.state.list.filter(p => p.id !== reserva.id);
        if(add) list.unshift(reserva); 
        return list;
    }

    updatefield(event) {
        const reserva = { ... this.state.reserva }
        reserva[event.target.name] = event.target.value /**em target pegamos o conteúdo de input name */
        this.setState({ reserva })
    }

    renderForm(){
        /**jsx que ira renderizar o formulário */
        return (
            <div className="form">
                <div className="row">
                    
                    
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>dataInicio</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="dataInicio" 
                                value={this.state.reserva.dataInicio}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite a data inicial."
                            />
                        </div>
                    </div>
                    
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>dataFim</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="dataFim" 
                                value={this.state.reserva.dataFim}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite a data de encerramento."
                            />
                        </div>
                    </div>
                   
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>acesso</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="acesso" 
                                value={this.state.reserva.acesso}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite o acesso."
                            />
                        </div>
                    </div>
                    
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>areaComum</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="areaComum" 
                                value={this.state.reserva.areaComum}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite a areaComum."
                            />
                        </div>
                    </div>
                    
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>condomino</label>
                            <input 
                                type="text" 
                                className="form-control" 
                                name="condomino" 
                                value={this.state.reserva.condomino}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite o condomino."
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
                                value={this.state.reserva.sistemaDeGaragem}
                                onChange={e => this.updatefield(e)}
                                placeholder="Digite a sistemaDeGaragem."
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

    load(reserva){
        this.setState({ reserva })/**atualiza o estado da aplicação. */
    }

    remove(reserva){
        axios.delete(`${baseUrl}/${reserva.id}`).then(resp => {
            const list = this.getUpdatedList(reserva, false)
            this.setState({ list })
        })
    }

    renderTable(){
        return(
            <table className="table mt-4">
               <thead>
                    <tr>
                        <th>Id</th>
                        <th>data inicial</th>
                        <th>Data final</th>
                        <th>acesso</th>
                        <th>Area reservada</th>
                        <th>Condômino responsável</th>
                        <th>Garagem</th>
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
        return this.state.list.map(reserva => {
            return (                
                <tr key={reserva.id}>
                    <td>{reserva.dataInicio}</td>
                    <td>{reserva.dataFim}</td>
                    <td>{reserva.acesso}</td>
                    <td>{reserva.areaComum}</td>
                    <td>{reserva.condomino}</td>
                    <td>{reserva.sistemaDeGaragem}</td>
                    <td>
                        <button className="btn btn-warning"
                        onClick={() => this.load(reserva)}>
                            <i className="fa fa-pencil"></i>
                        </button>
                        <button className="btn btn-danger ml-2"
                        onClick={() => this.remove(reserva)}>
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