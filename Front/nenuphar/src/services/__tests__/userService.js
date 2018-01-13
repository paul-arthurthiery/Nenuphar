import { login } from '../userService';

describe('userService.login', () => {
  it('should attempt a request', async () => {
    const response = await login('test', 'test');
    expect(response.data).toEqual(`le login`)
  });
});
