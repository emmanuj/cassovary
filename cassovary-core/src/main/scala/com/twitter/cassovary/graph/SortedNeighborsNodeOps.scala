/*
 * Copyright 2015 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.twitter.cassovary.graph

import com.twitter.cassovary.util.SortedArrayOps

/**
 * This trait designed to be mixed in to `Node` when neighbors of node
 * are sorted Arrays.
 */
trait SortedNeighborsNodeOps {
  self: Node =>

  override protected def containsNode(nodeIds: Seq[Int], queryNodeId: Int): Boolean = {
    SortedArrayOps.exists(nodeIds.toArray, queryNodeId)
  }

  override protected def intersect(neighbors: Seq[Int], nodeIds: Seq[Int]): Seq[Int] = {
    SortedArrayOps.intersectSorted(neighbors.toArray, nodeIds.toArray)
  }
}
