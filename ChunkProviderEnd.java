import java.util.List;
import java.util.Random;

public class ChunkProviderEnd implements IChunkProvider {
   private Random i;
   private NoiseGeneratorOctaves j;
   private NoiseGeneratorOctaves k;
   private NoiseGeneratorOctaves l;
   public NoiseGeneratorOctaves a;
   public NoiseGeneratorOctaves b;
   private World m;
   private double[] n;
   private BiomeGenBase[] o;
   double[] c;
   double[] d;
   double[] e;
   double[] f;
   double[] g;
   int[][] h = new int[32][32];

   public ChunkProviderEnd(World par1World, long par2) {
      this.m = par1World;
      this.i = new Random(par2);
      this.j = new NoiseGeneratorOctaves(this.i, 16);
      this.k = new NoiseGeneratorOctaves(this.i, 16);
      this.l = new NoiseGeneratorOctaves(this.i, 8);
      this.a = new NoiseGeneratorOctaves(this.i, 10);
      this.b = new NoiseGeneratorOctaves(this.i, 16);
   }

   public void func_40380_a(long par1, long par2, byte[] par3ArrayOfByte, BiomeGenBase[] par4ArrayOfBiomeGenBase) {
      byte byte0 = 2;
      int i = byte0 + 1;
      byte byte1 = 33;
      int j = byte0 + 1;
      this.n = this.func_40379_a(this.n, par1 * byte0, 0, par2 * byte0, i, byte1, j);

      for (int k = 0; k < byte0; k++) {
         for (int l = 0; l < byte0; l++) {
            for (int i1 = 0; i1 < 32; i1++) {
               double d = 0.25;
               double d1 = this.n[((k + 0) * j + l + 0) * byte1 + i1 + 0];
               double d2 = this.n[((k + 0) * j + l + 1) * byte1 + i1 + 0];
               double d3 = this.n[((k + 1) * j + l + 0) * byte1 + i1 + 0];
               double d4 = this.n[((k + 1) * j + l + 1) * byte1 + i1 + 0];
               double d5 = (this.n[((k + 0) * j + l + 0) * byte1 + i1 + 1] - d1) * d;
               double d6 = (this.n[((k + 0) * j + l + 1) * byte1 + i1 + 1] - d2) * d;
               double d7 = (this.n[((k + 1) * j + l + 0) * byte1 + i1 + 1] - d3) * d;
               double d8 = (this.n[((k + 1) * j + l + 1) * byte1 + i1 + 1] - d4) * d;

               for (int j1 = 0; j1 < 4; j1++) {
                  double d9 = 0.125;
                  double d10 = d1;
                  double d11 = d2;
                  double d12 = (d3 - d1) * d9;
                  double d13 = (d4 - d2) * d9;

                  for (int k1 = 0; k1 < 8; k1++) {
                     int l1 = k1 + k * 8 << 11 | 0 + l * 8 << 7 | i1 * 4 + j1;
                     char c = 128;
                     double d14 = 0.125;
                     double d15 = d10;
                     double d16 = (d11 - d10) * d14;

                     for (int i2 = 0; i2 < 8; i2++) {
                        int j2 = 0;
                        if (d15 > 0.0) {
                           j2 = Block.bJ.bO;
                        }

                        par3ArrayOfByte[l1] = (byte)j2;
                        l1 += c;
                        d15 += d16;
                     }

                     d10 += d12;
                     d11 += d13;
                  }

                  d1 += d5;
                  d2 += d6;
                  d3 += d7;
                  d4 += d8;
               }
            }
         }
      }
   }

   public void func_40381_b(long par1, long par2, byte[] par3ArrayOfByte, BiomeGenBase[] par4ArrayOfBiomeGenBase) {
      for (int i = 0; i < 16; i++) {
         for (int j = 0; j < 16; j++) {
            int k = 1;
            int l = -1;
            byte byte0 = (byte)Block.bJ.bO;
            byte byte1 = (byte)Block.bJ.bO;

            for (int i1 = 127; i1 >= 0; i1--) {
               int j1 = (j * 16 + i) * 128 + i1;
               byte byte2 = par3ArrayOfByte[j1];
               if (byte2 == 0) {
                  l = -1;
               } else if (byte2 == Block.t.bO) {
                  if (l == -1) {
                     if (k <= 0) {
                        byte0 = 0;
                        byte1 = (byte)Block.bJ.bO;
                     }

                     l = k;
                     if (i1 >= 0) {
                        par3ArrayOfByte[j1] = byte0;
                     } else {
                        par3ArrayOfByte[j1] = byte1;
                     }
                  } else if (l > 0) {
                     l--;
                     par3ArrayOfByte[j1] = byte1;
                  }
               }
            }
         }
      }
   }

   @Override
   public Chunk loadChunk(long par1, long par2) {
      return this.provideChunk(par1, par2);
   }

   @Override
   public Chunk provideChunk(long par1, long par2) {
      this.i.setSeed(par1 * 341873128712L + par2 * 132897987541L);
      byte[] abyte0 = new byte[32768];
      this.o = this.m.i().loadBlockGeneratorData(this.o, par1 * 16L, par2 * 16L, 16, 16);
      this.func_40380_a(par1, par2, abyte0, this.o);
      this.func_40381_b(par1, par2, abyte0, this.o);
      Chunk chunk = new Chunk(this.m, abyte0, par1, par2);
      byte[] abyte1 = chunk.m();

      for (int i = 0; i < abyte1.length; i++) {
         abyte1[i] = (byte)this.o[i].M;
      }

      chunk.b();
      return chunk;
   }

   private double[] func_40379_a(double[] par1ArrayOfDouble, long par2, int par3, long par4, int par5, int par6, int par7) {
      if (par1ArrayOfDouble == null) {
         par1ArrayOfDouble = new double[par5 * par6 * par7];
      }

      double d = 684.412;
      double d1 = 684.412;
      this.f = this.a.generateNoiseOctaves(this.f, par2, par4, par5, par7, 1.121, 1.121, 0.5);
      this.g = this.b.generateNoiseOctaves(this.g, par2, par4, par5, par7, 200.0, 200.0, 0.5);
      d *= 2.0;
      this.c = this.l.generateNoiseOctaves(this.c, par2, par3, par4, par5, par6, par7, d / 80.0, d1 / 160.0, d / 80.0);
      this.d = this.j.generateNoiseOctaves(this.d, par2, par3, par4, par5, par6, par7, d, d1, d);
      this.e = this.k.generateNoiseOctaves(this.e, par2, par3, par4, par5, par6, par7, d, d1, d);
      int i = 0;
      int j = 0;

      for (int k = 0; k < par5; k++) {
         for (int l = 0; l < par7; l++) {
            double d2 = (this.f[j] + 256.0) / 512.0;
            if (d2 > 1.0) {
               d2 = 1.0;
            }

            double d3 = this.g[j] / 8000.0;
            if (d3 < 0.0) {
               d3 = -d3 * 0.3;
            }

            d3 = d3 * 3.0 - 2.0;
            float f = (float)(k + par2 - 0L) / 1.0F;
            float f1 = (float)(l + par4 - 0L) / 1.0F;
            float f2 = 100.0F - MathHelper.c(f * f + f1 * f1) * 8.0F;
            if (f2 > 80.0F) {
               f2 = 80.0F;
            }

            if (f2 < -100.0F) {
               f2 = -100.0F;
            }

            if (d3 > 1.0) {
               d3 = 1.0;
            }

            d3 /= 8.0;
            d3 = 0.0;
            if (d2 < 0.0) {
               d2 = 0.0;
            }

            d2 += 0.5;
            d3 = d3 * par6 / 16.0;
            j++;
            double d4 = par6 / 2.0;

            for (int i1 = 0; i1 < par6; i1++) {
               double d5 = 0.0;
               double d6 = (i1 - d4) * 8.0 / d2;
               if (d6 < 0.0) {
                  d6 *= -1.0;
               }

               double d7 = this.d[i] / 512.0;
               double d8 = this.e[i] / 512.0;
               double d9 = (this.c[i] / 10.0 + 1.0) / 2.0;
               if (d9 < 0.0) {
                  d5 = d7;
               } else if (d9 > 1.0) {
                  d5 = d8;
               } else {
                  d5 = d7 + (d8 - d7) * d9;
               }

               d5 -= 8.0;
               d5 += f2;
               int j1 = 2;
               if (i1 > par6 / 2 - j1) {
                  double d10 = (i1 - (par6 / 2 - j1)) / 64.0F;
                  if (d10 < 0.0) {
                     d10 = 0.0;
                  }

                  if (d10 > 1.0) {
                     d10 = 1.0;
                  }

                  d5 = d5 * (1.0 - d10) + -3000.0 * d10;
               }

               int var51 = 8;
               if (i1 < var51) {
                  double d11 = (var51 - i1) / (var51 - 1.0F);
                  d5 = d5 * (1.0 - d11) + -30.0 * d11;
               }

               par1ArrayOfDouble[i] = d5;
               i++;
            }
         }
      }

      return par1ArrayOfDouble;
   }

   @Override
   public boolean chunkExists(long par1, long par2) {
      return true;
   }

   @Override
   public void populate(IChunkProvider par1IChunkProvider, long par2, long par3) {
      BlockSand.a = true;
      long i = par2 * 16L;
      long j = par3 * 16L;
      BiomeGenBase biomegenbase = this.m.getBiomeGenForCoords(i + 16L, j + 16L);
      biomegenbase.decorate(this.m, this.m.r, i, j);
      BlockSand.a = false;
   }

   @Override
   public boolean a(boolean par1, rw par2IProgressUpdate) {
      return true;
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean b() {
      return true;
   }

   @Override
   public String c() {
      return "RandomLevelSource";
   }

   @Override
   public List getPossibleCreatures(acf par1EnumCreatureType, long par2, int par3, long par4) {
      BiomeGenBase biomegenbase = this.m.getBiomeGenForCoords(par2, par4);
      return biomegenbase == null ? null : biomegenbase.a(par1EnumCreatureType);
   }

   @Override
   public ChunkPosition findClosestStructure(World par1World, String par2Str, long par3, int i, long j) {
      return null;
   }
}
