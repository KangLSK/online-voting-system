import axios from 'axios';

const API_BASE = 'http://localhost:8080/api/votes';

export const getVoteItems = () => axios.get(`${API_BASE}/items`);
export const vote = (payload) => axios.post(`${API_BASE}/vote`, payload);
export const addItem = (name) => axios.post(`${API_BASE}/items`, null, { params: { name } });
export const deleteItem = (id) => axios.delete(`${API_BASE}/items/${id}`);
