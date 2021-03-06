/***
 * 
 * Copyright 2014 Andrew Hall
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.statefulj.framework.core.model.impl;

import static java.beans.Introspector.decapitalize;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.statefulj.framework.core.model.ReferenceFactory;

public class ReferenceFactoryImpl implements ReferenceFactory {

	private String ctrl;
	
	public ReferenceFactoryImpl(String ctrl) {
		this.ctrl = ctrl;
	}

	@Override
	public String getBinderId(String key) {
		key = (!StringUtils.isEmpty(key)) ? "." + key : "";
		return decapitalize(ctrl + ".binder" + key);
	}

	@Override
	public String getFinderId() {
		return decapitalize(ctrl + ".finder");
	}

	@Override
	public String getFSMHarnessId() {
		return decapitalize(ctrl + ".fsmHarness");
	}

	@Override
	public String getPersisterId() {
		return decapitalize(ctrl + ".persister");
	}
	
	@Override
	public String getFactoryId() {
		return decapitalize(ctrl + ".factory");
	}
	
	@Override
	public String getStatefulFSMId() {
		return decapitalize(ctrl + ".statefulFSM");
	}
	
	@Override
	public String getFSMId() {
		return decapitalize(ctrl + ".fsm");
	}
	
	@Override
	public String getStateId(String state) {
		return decapitalize(ctrl + ".state." + state);
	}
	
	@Override
	public String getTransitionId(int cnt) {
		return decapitalize(ctrl + ".transition." + cnt);
	}
	
	@Override
	public String getActionId(Method method) {
		String id = decapitalize(ctrl + ".action." + method.getName());
		for (Class<?> clazz : method.getParameterTypes()) {
			id += "." + clazz.getName();
		}
		return  id;
	}
}
