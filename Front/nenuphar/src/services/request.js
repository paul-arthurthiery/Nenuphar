import axios from 'axios';

const TOKEN_STORAGE_KEY = "nenuphar_access_token";

const request = axios.create({
  baseURL: 'http://localhost:8080',
  timeout: 1000,
  headers: {}
});

export function getJson(url) {
  if (localStorage.getItem(TOKEN_STORAGE_KEY)) {
    // TODO transform request to send the token
  }

  return request.get(url);
}

export function postJson(url, body) {
  return request.post(url, body);
}

export function setToken(token) {
  localStorage.setItem(TOKEN_STORAGE_KEY, token);
}
