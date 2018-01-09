package com.nenuphar.nenufar.Controllers;


import com.nenuphar.nenufar.Models.LDAP;
import com.nenuphar.nenufar.Services.LDAPService;

class TestLDAP
{
	public static void main(String[] args)
	{
		LDAPService access = new LDAPService();
		try {
			//Enter login and password Here
		LDAP test = access.LDAPget("LOGIN", "PASSWORD");
		if (test == null)
		{
			System.out.println("login invalide");
			System.exit(1);
		}
		System.out.println(test.toString());
		System.exit(0);
		} catch(Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
}