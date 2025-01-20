package com.auberge.fantasy;

import com.auberge.fantasy.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class scheduledays {

    private static final Logger log = LoggerFactory.getLogger(scheduledays.class);

    private List<Item> items;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public scheduledays() {
        items = new ArrayList<>();
        items.add(new Item(15, 15, "zffzcr"));
        items.add(new Item(15, 45, "Aged Brie"));
        items.add(new Item(15, 15, "Backstage passes"));
        items.add(new Item(20, 80, "Sulfuras"));
        log.info(items.toString());
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("a new day has come {}", dateFormat.format(new Date()));
        updateQuality(items);
    }

    private static void updateQuality(List<Item> itemToUpdate) {
        for (Item item : itemToUpdate) {
            log.info(" for this item today : " + item.toString());
            if (item.getName().equalsIgnoreCase("Sulfuras")) {
                item.setSellIn(0);
                continue;
            }
            int localQual = item.getQuality();
            int localSell = item.getSellIn();
            boolean agedbrieValide = item.getName().equalsIgnoreCase("Aged Brie");
            boolean backstagePassValide = item.getName().equalsIgnoreCase("Backstage passes");
            boolean conjuredValide = item.getName().equalsIgnoreCase("Conjured");
            if (localQual < 50) {
                if (agedbrieValide || backstagePassValide) {
                    localQual++;
                    if (backstagePassValide) {
                        if (localSell < 10) {
                            localQual++;
                            if (localSell < 5) {
                                localQual++;
                            }
                        }
                        if (localSell < 1) {
                            localQual = 0;
                        }
                    }
                } else {
                    if (localQual > 0) {
                        localQual--;
                        if (localSell == 0) {
                            localQual--;
                        }
                        if (conjuredValide) {
                            localQual--;
                        }
                    }
                }
            }
            if (localSell > 0) {
                localSell--;
            }
            item.setQuality(localQual);
            item.setSellIn(localSell);
        }
    }
}
