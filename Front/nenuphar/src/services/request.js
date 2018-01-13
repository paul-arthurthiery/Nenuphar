import axios from 'axios';

const request = axios.create({
  baseURL: 'http://localhost:8080',
  timeout: 1000,
  headers: {}
});

export function getJson(url) {
  return request.get(url);
}

export function postJson(url, body) {
  return request.post(url, body);
}
