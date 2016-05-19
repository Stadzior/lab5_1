package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RadarTest {
	@Test
	public void launchPatriotOnceWhenNoticesAScudMissle() {
		PatriotBattery batteryMock = mock(PatriotBattery.class);
        Executor executor = new Executor(){

            @Override
            public void execute(Runnable command) {
                command.run();
            }
        };
        BetterRadar radar = new BetterRadar(batteryMock,executor);
		radar.notice(new Scud());
		verify(batteryMock).launchPatriot();
	}

}
