import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

import * as api from '../api/index';

import Modal from "../components/ModalComp";

import Table from 'react-bootstrap/Table'
import Button from 'react-bootstrap/Button'

const ServicosIndex = () => {
  const [servicos, setServicos] = useState([])

  const [modalInfo, setModalInfo] = useState({
    show: false,
    title: '',
    msg: ''
  });

  const fetchServicos = async() => {
    const response = await api.listarServicos();
    setServicos(response.data.data);
  };

  useEffect(() => {
    fetchServicos();
  }, [servicos.length]);

  const removerServico = async (payload) => {
    const remove = window.confirm('Tem certeza que deseja remover o formulário');
    if (remove) {
      await api.removerServico(payload)

      fetchServicos();
    }
  };

  const validarServico = async (payload) => {
    try {
      const response = await api.validarServico(payload);
      setModalInfo({ show: true, title: 'OK', msg: response.data});

    } catch (error) {
      let msg = '';
      if (typeof error.response == 'undefined') {
        msg = error.response;
      } else {
        msg = error.response.data;
      }
      setModalInfo({ show: true, title: 'ERRO', msg: msg });
    }
  };

  const onCloseModal = () => {
    setModalInfo({ show: false, title: '', msg: '' });
  };

  return (
    <>
      <Modal data={modalInfo} onCloseModal={onCloseModal}></Modal>

      <h1>Servicos</h1>

      <div className="novo_servico">
        <Link to="/new">
          <Button variant="secondary">Novo serviço</Button>
        </Link>
      </div>


      <Table striped bordered hover>
        <thead>
        <tr>
          <th>Tipo Serviço</th>
          <th>Descrição</th>
          <th>Since ID</th>
          <th>Todas Palavras</th>
          <th>Algumas Palavras</th>
          <th>Nenhuma Palavras</th>
          <th colSpan="2">URL</th>
        </tr>
        </thead>
        <tbody>
        { servicos.map(s => {
          return (<tr key={s.id}>
            <td>{s.tipoServico}</td>
            <td>{s.nome}</td>
            <td>{s.sinceID}</td>
            <td>{s.todasPalavras}</td>
            <td>{s.algumasPalavras}</td>
            <td>{s.nenhumaPalavras}</td>
            <td>{s.url}</td>
            <td>
              <Button variant="primary" onClick={() => validarServico(s)}>Validar</Button>

              <Link to={`${s.id}/edit`}>
                <Button variant="info">Editar</Button>
              </Link>

              <Button variant="danger" onClick={() => removerServico(s)}>Remover</Button>
            </td>
          </tr>)
        }) }
        </tbody>
      </Table>
    </>
  )
};

export default  ServicosIndex;