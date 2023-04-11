import java.util.*

class Solution {
    data class Frame(val x: Int, val y: Int, val type: Int)

    fun canInstall(frame: Frame, frames: HashSet<Frame>): Boolean {
        val (x, y, type) = frame
        return when (type) {
            0 -> (y == 0 || frames.contains(Frame(x, y - 1, 0))
                    || frames.contains(Frame(x - 1, y, 1))
                    || frames.contains(Frame(x, y, 1)))
            1 -> (frames.contains(Frame(x, y - 1, 0))
                    || frames.contains(Frame(x + 1, y - 1, 0))
                    || (frames.contains(Frame(x - 1, y, 1)) && frames.contains(Frame(x + 1, y, 1))))
            else -> false
        }
    }

    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        val frames = hashSetOf<Frame>()

        for (build in build_frame) {
            val (x, y, type, op) = build
            val frame = Frame(x, y, type)

            when (op) {
                0 -> {
                    frames.remove(frame)
                    if (frames.any { !canInstall(it, frames) }) {
                        frames.add(frame)
                    }
                }
                1 -> {
                    if (canInstall(frame, frames)) {
                        frames.add(frame)
                    }
                }
            }
        }

        return frames.sortedWith(compareBy({ it.x }, { it.y }, { it.type })).map { intArrayOf(it.x, it.y, it.type) }.toTypedArray()
    }

}