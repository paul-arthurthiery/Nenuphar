import { postJson } from './request';

export function login(username, password) {
  return postJson("/test", {
    login: username,
    password: password,
  });
}
