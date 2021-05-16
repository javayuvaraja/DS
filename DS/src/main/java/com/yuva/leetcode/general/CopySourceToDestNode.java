package com.yuva.leetcode.general;

/**
 * 
 * Facebook question class Node { char c[]; int len; Node* next; }
 * 
 * 
 * src: [fa] -> [ce] -> [bo] -> [ok] dst (before): [aaaa] -> [aaaa] -> [aaaa]
 * dst (after): [face] -> [book] -> [aaaa]
 * 
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class CopySourceToDestNode {

	class Node {
		char c[];
		int len;
		Node next;
	}

	public void copy(Node src, Node dest) {
		if (src == null) {
			return;
		}

		Node srcHead = src;
		Node destHead = dest;

		int sourceIndex = 0;
		int destIndex = 0;

		while (srcHead != null) {
			if (sourceIndex == srcHead.len) {
				srcHead = srcHead.next;
				sourceIndex = 0;
				continue;
			}
			if (destIndex == destHead.len) {
				destHead = destHead.next;
				destIndex = 0;
				continue;
			}
			destHead.c[destIndex++] = srcHead.c[sourceIndex++];
		}
	}

	public void copy1(Node src, Node dst) {
		if (src == null)
			return;
		Node srcHead = src;
		Node dstHead = dst;
		int sIndex = 0;
		int dIndex = 0;
		while (srcHead != null) {
			int cpyLen = Math.min(srcHead.len - sIndex, dstHead.len - dIndex);
			memcpy(srcHead, dstHead, cpyLen);
			sIndex += cpyLen;
			dIndex += cpyLen;
			if (sIndex == srcHead.len) {
				sIndex = 0;
				srcHead = srcHead.next;
			}

			if (dIndex == dstHead.len) {
				dIndex = 0;
				dstHead = dstHead.next;
			}
		}
	}

	public void memcpy(Node src, Node dst, int len) {

	}
}
