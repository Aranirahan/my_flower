

package com.example.aran.my_flower.model.callback;

import com.example.aran.my_flower.model.pojo.Flower;

import java.util.List;

public interface FlowerFetchListener {

    void onDeliverAllFlowers(List<Flower> flowers);

    void onDeliverFlower(Flower flower);

    void onHideDialog();
}
