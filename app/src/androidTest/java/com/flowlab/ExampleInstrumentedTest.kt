
package com.flowlab

import com.flowlab.counter.CounterRepository
import org.junit.Assert.assertEquals
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun newRepository_startsAtZero() {
        val repository = CounterRepository()

        assertEquals(0, repository.count)
    }

    @Test
    fun increment_increasesCountByOne() {
        val repository = CounterRepository()

        repository.increment()

        assertEquals(1, repository.count)
    }

    @Test
    fun multipleIncrements_increaseCountCorrectly() {
        val repository = CounterRepository()

        repository.increment()
        repository.increment()
        repository.increment()

        assertEquals(3, repository.count)
    }

    @Test
    fun manyIncrements_countMatchesExpectedValue() {
        val repository = CounterRepository()

        repeat(100) {
            repository.increment()
        }

        assertEquals(100, repository.count)
    }

    @Test
    fun separateRepositories_haveIndependentCounts() {
        val first = CounterRepository()
        val second = CounterRepository()

        first.increment()
        first.increment()

        assertEquals(2, first.count)
        assertEquals(0, second.count)
    }
}
