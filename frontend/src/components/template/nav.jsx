import React from 'react'
import './nav.css'

import { Link } from 'react-router-dom'

export default props =>
    <aside className="menu-area">
        <nav className="menu">
            <Link to="/">
                <i className="fa fa-home"></i> Home
            </Link>
            <Link to="/condominos">
                <i class="fa fa-user"></i> Condôminos
            </Link>
            <Link to="/familias">
                <i className="fa fa-users"></i> Famílias
            </Link>
            <Link to="/sindicos">
                <i className="fa fa-user"></i> Síndico
            </Link>
            <Link to="/visitantes">
                <i className="fa fa-user"></i> Visitantes
            </Link>
            <Link to="/prestadorDeServicos">
                <i className="fa fa-user"></i> PrestadorDeServicos
            </Link>
            <Link to="/acessos">
                <i className="fa fa-product-hunt"></i> Acessos
            </Link>
            <Link to="/areasComuns">
                <i className="fa fa-product-hunt"></i> AreasComuns
            </Link>
            <Link to="/reservas">
                <i className="fa fa-product-hunt"></i> Reservas
            </Link>
        </nav>
    </aside>