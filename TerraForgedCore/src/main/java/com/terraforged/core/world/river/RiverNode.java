/*
 *   
 * MIT License
 *
 * Copyright (c) 2020 TerraForged
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.terraforged.core.world.river;

public class RiverNode {

    public final int x;
    public final int z;
    public final Type type;

    public RiverNode(int x, int z, Type type) {
        this.x = x;
        this.z = z;
        this.type = type;
    }

    public static Type getType(float value) {
        if (River.validStart(value)) {
            return Type.START;
        }
        if (River.validEnd(value)) {
            return Type.END;
        }
        return Type.NONE;
    }

    public enum Type {
        NONE {
            @Override
            public Type opposite() {
                return this;
            }
        },
        START {
            @Override
            public Type opposite() {
                return END;
            }
        },
        END {
            @Override
            public Type opposite() {
                return START;
            }
        },
        ;

        public abstract Type opposite();
    }
}
