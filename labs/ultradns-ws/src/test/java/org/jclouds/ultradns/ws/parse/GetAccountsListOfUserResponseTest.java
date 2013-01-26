/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.ultradns.ws.parse;

import static org.testng.Assert.assertEquals;

import java.io.InputStream;

import org.jclouds.http.functions.BaseHandlerTest;
import org.jclouds.ultradns.ws.domain.Account;
import org.jclouds.ultradns.ws.xml.AccountHandler;
import org.testng.annotations.Test;

/**
 * @author Adrian Cole
 */
@Test
public class GetAccountsListOfUserResponseTest extends BaseHandlerTest {

   public void test() {
      InputStream is = getClass().getResourceAsStream("/account.xml");

      Account expected = expected();

      AccountHandler handler = injector.getInstance(AccountHandler.class);
      Account result = factory.create(handler).parse(is);

      assertEquals(result, expected);
   }

   public Account expected() {
      return Account.fromIdAndName("01233CB945FAC523", "jclouds");
   }

}
