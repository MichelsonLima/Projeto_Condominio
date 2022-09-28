import React from "react";
import './home.css'
import Main from '../template/main'

export default props =>
    <Main icon="home" title="Início" subtitle="Gerenciamento de condomínio">
        <div className="display-4">Bem vindo</div>
        <hr />
        <p className="mb-0">Gerenciamento de condomínio</p>
    </Main>
