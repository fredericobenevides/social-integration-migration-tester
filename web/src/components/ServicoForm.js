import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom';

import { Link } from 'react-router-dom';

import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

import * as api from '../api';

const ServicoForm = (props) => {

  let history = useHistory();

  const [ form, setForm ] = useState({
    id: 0,
    tipoServico: '',
    nome: '',
    sinceID: '',
    todasPalavras: '',
    algumasPalavras: '',
    nenhumaPalavras: '',
    url: ''
  });

  useEffect(() => {
    if (typeof props.form !== 'undefined') {
      setForm(props.form);
    }
  }, [form.id]);

  const onFormSubmit = async (e) => {
    e.preventDefault();

    if (form.id === 0) {
      await api.salvarServico(form);
      alert('Serviço salvo');
    } else {
      await api.atualizarServico(form);
      alert('Serviço atualizado');
    }

    history.push('/');
  };

  return (
    <>
      <Form onSubmit={onFormSubmit}>
        <Form.Group controlId="tipoServico">
          <Form.Label>Tipo Serviço:</Form.Label>
          <Form.Control type="text" value={form.tipoServico} onChange={e => setForm({ ...form, tipoServico: e.target.value })}/>
        </Form.Group>

        <Form.Group controlId="nome">
          <Form.Label>Descrição:</Form.Label>
          <Form.Control type="text" value={form.nome} onChange={e => setForm({ ...form, nome: e.target.value })}/>
        </Form.Group>

        <Form.Group controlId="sinceID">
          <Form.Label>Since ID:</Form.Label>
          <Form.Control type="text" value={form.sinceID} onChange={e => setForm({ ...form, sinceID: e.target.value })}/>
        </Form.Group>

        <Form.Group controlId="todasPalavras">
          <Form.Label>Todas Palavras:</Form.Label>
          <Form.Control type="text" value={form.todasPalavras} onChange={e => setForm({ ...form, todasPalavras: e.target.value })}/>
        </Form.Group>

        <Form.Group controlId="algumasPalavras">
          <Form.Label>Algumas Palavras:</Form.Label>
          <Form.Control type="text" value={form.algumasPalavras} onChange={e => setForm({ ...form, algumasPalavras: e.target.value })}/>
        </Form.Group>

        <Form.Group controlId="nenhumaPalavras">
          <Form.Label>Nenhuma Palavras:</Form.Label>
          <Form.Control type="text" value={form.nenhumaPalavras} onChange={e => setForm({ ...form, nenhumaPalavras: e.target.value })}/>
        </Form.Group>

        <Form.Group controlId="url">
          <Form.Label>URL:</Form.Label>
          <Form.Control type="text" value={form.url} onChange={e => setForm({ ...form, url: e.target.value })}/>
        </Form.Group>

        <Button type="submit" variant="primary">Salvar</Button>

        <Link to="/">
          <Button variant="light">Voltar</Button>
        </Link>

      </Form>
    </>
  )
};

export default ServicoForm;