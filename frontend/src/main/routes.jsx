import React from 'react'
import { Switch, Route, Redirect } from 'react-router'

import Home from '../components/home/home'
import CondominoCrud from '../components/condomino/CondominoCrud'
import FamiliaCrud from '../components/familia/FamiliaCrud'
import SindicoCrud from '../components/sindico/SindicoCrud'
import VisitanteCrud from '../components/visitante/VisitanteCrud'
import PrestadorDeServicoCrud from '../components/prestadorDeServico/PrestadorDeServicoCrud'
import AcessoCrud from '../components/acesso/AcessoCrud'
import AreaComumCrud from '../components/areaComum/AreaComumCrud'
import ReservaCrud from '../components/reserva/ReservaCrud'

/*Mapeamento dos links aos componentes*/
export default props =>
    <Switch>
        <Route exact path="/" component={Home} />
        <Route exact path="/condominos" component={CondominoCrud} />
        <Route exact path="/familias" component={FamiliaCrud} />
        <Route exact path="/sindicos" component={SindicoCrud} />
        <Route exact path="/visitantes" component={VisitanteCrud} />
        <Route exact path="/prestadorDeServicos" component={PrestadorDeServicoCrud} />  
        <Route exact path="/acessos" component={AcessoCrud} />
        <Route exact path="/areasComuns" component={AreaComumCrud} />
        <Route exact path="/reservas" component={ReservaCrud} />
        <Redirect from="*" to="/" />
    </Switch>



/* A /" chama o componente home.
"/users" chama o componente user-crud
Caso seja uma url não declarada "*" redireciona para "/" raiz.*/