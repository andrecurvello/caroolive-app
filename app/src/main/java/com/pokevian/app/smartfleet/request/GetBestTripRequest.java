/*
 * Copyright (c) 2014. Pokevian Ltd.
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

package com.pokevian.app.smartfleet.request;

import com.android.volley.Response;
import com.pokevian.app.smartfleet.model.MemberEcoData;
import com.pokevian.app.smartfleet.setting.ServerUrl;
import com.pokevian.app.smartfleet.volley.GsonRequest;
import com.pokevian.app.smartfleet.volley.VolleyListener;
import com.pokevian.app.smartfleet.volley.VolleyParams;


public class GetBestTripRequest extends GsonRequest<MemberEcoData> {

    public GetBestTripRequest(String yyyyMMdd, String period, String memberNo, final VolleyListener<MemberEcoData> listener) {
        super(ServerUrl.GET_RANKING_BEST_TRIP_API, MemberEcoData.class, listener);

        VolleyParams params = new VolleyParams();
        params.put("date", yyyyMMdd);
        params.put("period", period);
        params.put("memberNo", memberNo);
        setParams(params);

        setListener(new Response.Listener<MemberEcoData>() {
            @Override
            public void onResponse(MemberEcoData response) {
                listener.onResponse(response);
            }
        });
    }
}
