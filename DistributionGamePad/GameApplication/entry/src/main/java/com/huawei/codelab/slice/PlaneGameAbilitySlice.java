/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huawei.codelab.slice;

import com.huawei.codelab.ResourceTable;
import com.huawei.codelab.game.GameView;
import com.huawei.codelab.game.Handle;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

import java.util.List;

/**
 * plane game ability slice
 *
 * @since 2021-03-15
 *
 */
public class PlaneGameAbilitySlice extends AbilitySlice {
    private static final HiLogLabel TAG = new HiLogLabel(HiLog.LOG_APP, 0xD001400, "fxh");
    private static GameView gameView;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_plane_game);

        Component component = findComponentById(ResourceTable.Id_canvasView);
        if (component instanceof GameView) {
            gameView = (GameView) component; // 获取页面
        }
        setGameView(MainAbilitySlice.getHandles());
        gameView.start(MainAbilitySlice.getDeviceIds());
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    private void setGameView(List<Handle> handles) {
        for (Handle handle: handles) {
            handle.setGameView(gameView);
        }
    }
}
