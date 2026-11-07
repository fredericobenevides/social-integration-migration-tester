import React, { useState, useEffect } from 'react';

import ServicoForm from "../components/ServicoForm";

import * as api from '../api';

const ServicoEdit = ({ match }) => {
  const [ form, setForm ] = useState({ id: 0 });

  const fetchServico = async (id) => {
    try {
      const response = await api.listarServicos();
      const listaServicos = response.data.data;

      const servico = listaServicos.filter(s => s.id === parseInt(id))[0];
      setForm(servico);
    } catch (error) {
      alert('Erro ao editar o formulário')
    }
  };

  useEffect(() => {
    fetchServico(match.params.id);
  }, [match.params.id]);

  if (form.id === 0) {
    return (
      <>
        <p>Carregando o serviço....</p>
      </>
    )
  } else {
    return (
      <>
        <h1>Formulário</h1>
        <ServicoForm form={form}></ServicoForm>
      </>
    )
  }

};

export default ServicoEdit;