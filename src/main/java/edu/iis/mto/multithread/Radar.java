package edu.iis.mto.multithread;

public class Radar {
	private PatriotBattery battery;

	public Radar(PatriotBattery missle) {
		this.battery = missle;
	}

	public void notice(Scud enemyMissle) {
		launchPatriot();
	}

	private void launchPatriot() {
		Runnable launchPatriotTask = () -> {
            for (int i = 0; i < 10; i++) {
                battery.launchPatriot();
            }
        };

		Thread launchingThread = new Thread(launchPatriotTask);
		launchingThread.start();
	}
}
