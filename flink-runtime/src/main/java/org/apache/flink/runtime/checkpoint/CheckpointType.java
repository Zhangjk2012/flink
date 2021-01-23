/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.runtime.checkpoint;

/** The type of checkpoint to perform. */
public enum CheckpointType {

    /** A checkpoint, full or incremental. */
    CHECKPOINT(false, false, "Checkpoint"),

    /** A regular savepoint. */
    SAVEPOINT(true, false, "Savepoint"),

    /** A savepoint taken while suspending/terminating the job. */
    SYNC_SAVEPOINT(true, true, "Synchronous Savepoint");

    private final boolean isSavepoint;

    private final boolean isSynchronous;

    private final String name;

    CheckpointType(final boolean isSavepoint, final boolean isSynchronous, final String name) {

        this.isSavepoint = isSavepoint;
        this.isSynchronous = isSynchronous;
        this.name = name;
    }

    public boolean isSavepoint() {
        return isSavepoint;
    }

    public boolean isSynchronous() {
        return isSynchronous;
    }

    public String getName() {
        return name;
    }
}
