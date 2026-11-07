import axios from 'axios';

export const listarServicos = () => {
  return axios.get('/core/listar');
};

export const salvarServico = servico => {
  return axios.post('/core/salvar', servico);
};

export const atualizarServico = servico => {
  return axios.post('/core/atualizar', servico);
};

export const removerServico = servico => {
  return axios.delete(`/core/remover/${servico.id}`);
};

export const validarServico = servico => {
  return axios.get(`/core/validar/${servico.id}`);
};
