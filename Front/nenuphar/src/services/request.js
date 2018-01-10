import axios from 'axios';

const request = axios.create({
  baseURL: 'https://localhost:8000/',
  timeout: 1000,
  headers: {'X-Custom-Header': 'foobar'}
});

export function getJson(url) {
  return request.get(url);
}
