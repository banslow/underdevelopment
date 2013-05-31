/*
 * Copyright (C) 2013 uPhyca Inc. 
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

package com.uphyca.sql;

import android.database.sqlite.SQLiteQueryBuilder;

public final class LazyLoading {

    public static final SQLiteQueryBuilder newQueryBuilder(CountQueryBuilder builder) {
        return new LazyLoadingSQLiteQueryBuilder(builder);
    }

    public static final SQLiteQueryBuilder newQueryBuilder(CountQueryBuilder builder, int blockSize) {
        return new LazyLoadingSQLiteQueryBuilder(builder, blockSize);
    }

    public static final SQLiteQueryBuilder newQueryBuilder() {
        return new LazyLoadingSQLiteQueryBuilder(null);
    }

    public static final SQLiteQueryBuilder newQueryBuilder(int blockSize) {
        return new LazyLoadingSQLiteQueryBuilder(null, blockSize);
    }
}
