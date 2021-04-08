// Set LED for Lodi, GNU GPL
//
// Call: java setLED <ip-address of LoDi SC> <node> <status> # set Status
//       java setLED <ip-address of LoDi SC> <hh:mm>         # set Time
//
// API documentation LoDi
//   1. https://www.lokstoredigital.de/service/ger%C3%A4te-api/allgemeines/
//   2. https://www.lokstoredigital.de/service/ger%C3%A4te-api/lodi-shift-commander/
//
// Status:
//   0: Beleuchtung aus
//   1: Licht-Kurve 1
//   2: Licht-Kurve 2
//   3: Licht-Kurve 3
//   8: Blitz
//   9: Doppelblitz
//   10: zufälliges Blitzen
//   11: Wolkenzug

import java.net.*;
import java.io.*;

public class setLED {

  public static void main( String[] args ) throws IOException {

    String      host    = args[0];
    InetAddress address = InetAddress.getByName(host);
    final int   port    = 11092;

    byte[] timeSet        = { (byte)0x20, (byte)0x77,
                              (byte)0x42, (byte)0x00,
			                  (byte)0x00 };
    byte[] nodeStatusSend = { (byte)0x20, (byte)0x6C,
                              (byte)0x42, (byte)0x01,
                              (byte)0x00, (byte)0x00 };

    final int receiveSize = 4096;

    DatagramSocket socket = new DatagramSocket();
    DatagramPacket packetReceive = new DatagramPacket( new byte[receiveSize], receiveSize );
    DatagramPacket packetSend;

    if ( args[1].indexOf(':') != -1 ) {
       int hh = Integer.parseInt(args[1].substring(0,2));
       int mm = Integer.parseInt(args[1].substring(3,5));
       int units = hh * 1800 + mm * 30;
       byte high = (byte)(units / 256);
       byte low = (byte)(units % 256);
       timeSet[3] = high;
       timeSet[4] = low;
       packetSend = new DatagramPacket(timeSet, timeSet.length, address, port);
    }
    else {
       byte node = (byte)Integer.parseInt(args[1]);
       byte status = (byte)Integer.parseInt(args[2]);
       nodeStatusSend[4] = node;
       nodeStatusSend[5] = status;
       packetSend = new DatagramPacket(nodeStatusSend, nodeStatusSend.length, address, port);
    }

    int    len  = packetSend.getLength();
    byte[] data = packetSend.getData();
    for ( int i=0; i<len; i++ ) {
      System.out.printf( "%02X ", data[i] );
    }
    System.out.println();  

    socket.send(packetSend);
    socket.receive( packetReceive );

    len  = packetReceive.getLength();
    data = packetReceive.getData();
    for ( int i=0; i<len; i++ ) {
      System.out.printf( "%02X ", data[i] );
    }
    System.out.println();
  } // main

} // public class setLED