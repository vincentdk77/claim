package com.sinosoft.claimciplatform.util;

import java.net.InetAddress;
public class UUID {
    
    private static short counter = (short) 0;
    private static final String sep = "";
    private static final int IP;
    private static final int JVM = (int) (System.currentTimeMillis() >>> 8);
    
    static {
        int ipadd;
        try {
            ipadd = ByteUtils.toInt( InetAddress.getLocalHost().getAddress() );
        }
        catch (Exception e) {
            ipadd = 0;
        }
        IP = ipadd;
    }
    
    private UUID() {
    }
    
    public static String generate() {
        return new StringBuffer(36)
        .append( format( getIP() ) ).append(sep)
        .append( format( getJVM() ) ).append(sep)
        .append( format( getHiTime() ) ).append(sep)
        .append( format( getLoTime() ) ).append(sep)
        .append( format( getCount() ) )
        .toString();
    }
    
    private static String format(int intval) {
        String formatted = Integer.toHexString(intval);
        StringBuffer buf = new StringBuffer("00000000");
        buf.replace( 8-formatted.length(), 8, formatted );
        return buf.toString();
    }
    
    private static String format(short shortval) {
        String formatted = Integer.toHexString(shortval);
        StringBuffer buf = new StringBuffer("0000");
        buf.replace( 4-formatted.length(), 4, formatted );
        return buf.toString();
    }
    
    
    /**
     * Unique across JVMs on this machine (unless they load this class
     * in the same quater second - very unlikely)
     */
    private static int getJVM() {
        return JVM;
    }
    
    /**
     * Unique in a millisecond for this JVM instance (unless there
     * are > Short.MAX_VALUE instances created in a millisecond)
     */
    private static short getCount() {
        synchronized(UUID.class) {
            if (counter<0) counter=0;
            return counter++;
        }
    }
    
    /**
     * Unique in a local network
     */
    private static int getIP() {
        return IP;
    }
    
    /**
     * Unique down to millisecond
     */
    private static short getHiTime() {
        return (short) ( System.currentTimeMillis() >>> 32 );
    }
    
    private static int getLoTime() {
        return (int) System.currentTimeMillis();
    }
    
}
