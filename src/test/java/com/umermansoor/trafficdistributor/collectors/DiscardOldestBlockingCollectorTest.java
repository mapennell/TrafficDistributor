package com.umermansoor.trafficdistributor.collectors;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DiscardOldestBlockingCollectorTest {
    @Test
    public void put_discardOldestElementWhenFull() {
        int capacity = 4;
        DiscardOldestBlockingCollector discardOldest = new DiscardOldestBlockingCollector(capacity);
        try {
            String[] events = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};

            for (String s : events) {
                discardOldest.put(s);
            }
            assertEquals(capacity, discardOldest.size());

            for (int i = capacity; i < events.length; i++) {
                assertEquals(events[i], discardOldest.get());
            }

        } catch (Exception e) {
            fail("exception thrown");
        }
    }

}
