package kin.core.sample;

import android.app.Application;
import kin.core.KinClient;
import kin.core.ServiceProvider;

public class KinClientSampleApplication extends Application {

    //based on parity
    private final String TEST_NET_URL = "https://horizon-testnet.stellar.org";
    private final String MAIN_NET_URL = "https://horizon.stellar.org";

    public enum NetWorkType {
        MAIN,
        TEST
    }

    private KinClient kinClient = null;

    public KinClient createKinClient(NetWorkType type) {
        String providerUrl;
        int netWorkId;
        switch (type) {
            case MAIN:
                providerUrl = MAIN_NET_URL;
                netWorkId = ServiceProvider.NETWORK_ID_MAIN;
                break;
            case TEST:
                providerUrl = TEST_NET_URL;
                netWorkId = ServiceProvider.NETWORK_ID_TEST;
                break;
            default:
                providerUrl = TEST_NET_URL;
                netWorkId = ServiceProvider.NETWORK_ID_TEST;
        }
        kinClient = new KinClient(this,
            new ServiceProvider(providerUrl, netWorkId));
        return kinClient;
    }

    public KinClient getKinClient() {
        return kinClient;
    }
}
