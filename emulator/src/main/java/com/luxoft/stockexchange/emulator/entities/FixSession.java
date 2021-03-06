package com.luxoft.stockexchange.emulator.entities;

import java.util.ArrayList;
import java.util.List;

import quickfix.SessionID;

public class FixSession {
	//TODO change to string generator or ID from DB
	private static int idCounter = 0;
	private int id;
	private SessionID session;
	//TODO now no logic is tied on this
	private Status status;
	private final List<FixMessage> seqIn = new ArrayList<>();
	private final List<FixMessage> seqOut = new ArrayList<>();
	
	public enum Status { ACTIVE, STOPPED }

	public FixSession(SessionID session) {
		this.session = session;
		id = idCounter++;
		status = Status.ACTIVE;
	}
	
	public int getId() {
		return id;
	}

	public FixSession setId(int id) {
		this.id = id;
		return this;
	}

	public SessionID getSession() {
		return session;
	}

	public FixSession setSession(SessionID session) {
		this.session = session;
		return this;
	}

	public Status getStatus() {
		return status;
	}

	public FixSession setStatus(Status status) {
		this.status = status;
		return this;
	}

	public List<FixMessage> getSeqIn() {
		return seqIn;
	}

	public List<FixMessage> getSeqOut() {
		return seqOut;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append("id: "  + id);
		str.append(", messages in: "  + seqIn.size());
		str.append(", messages out: "  + seqOut.size());
		
		return str.toString();
	}
}
