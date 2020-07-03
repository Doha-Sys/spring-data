/*
 * DISCLAIMER
 *
 * Copyright 2018 ArangoDB GmbH, Cologne, Germany
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright holder is ArangoDB GmbH, Cologne, Germany
 */

package com.arangodb.springframework.debug.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.arangodb.springframework.AbstractArangoTest;
import com.arangodb.springframework.debug.repository.entity.LongEntity;

/**
 * @author Michele Rastelli
 */
public class LongEntityRepositoryTest extends AbstractArangoTest {

	@Autowired
	private LongEntityRepository repo;

	@Test
	@Ignore
	public void save() {
		LongEntity entity = new LongEntity();
		entity.setId(1L);
		entity.setValue(2L);

		LongEntity saved = repo.save(entity);
		Optional<LongEntity> fetched = repo.findById(entity.getId());

		assertThat(saved, is(entity));
		assertThat(fetched.isPresent(), is(true));
		assertThat(fetched.get(), is(entity));
	}
}
