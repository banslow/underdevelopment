/*
 * Copyright (C) 2012 uPhyca Inc. http://www.uphyca.com/
 * 
 * Android Advent Calendar 2012 http://androidadvent.blogspot.jp/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.uphyca.testing;

import android.app.Activity;
import android.test.ActivityUnitTestCase;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.uphyca.myfirst.di.inject.InjectionApplication;

public abstract class InjectionActivityUnitTestCase<T extends Activity> extends ActivityUnitTestCase<T> {

    public InjectionActivityUnitTestCase(Class<T> activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        
        Injector injector = Guice.createInjector(new MockModule(this));

        //テストクラスの@Dependencyで注釈されたフィールドにInjectionする
        injector.injectMembers(this);

        InjectionApplication injectionApp = new InjectionApplication();
        injectionApp.setInjector(injector);
        setApplication(injectionApp);
    }
}
