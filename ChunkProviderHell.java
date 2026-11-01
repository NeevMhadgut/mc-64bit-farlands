import java.util.List;
import java.util.Random;

public class ChunkProviderHell implements IChunkProvider {
   private Random i;
   private NoiseGeneratorOctaves j;
   private NoiseGeneratorOctaves k;
   private NoiseGeneratorOctaves l;
   private NoiseGeneratorOctaves m;
   private NoiseGeneratorOctaves n;
   public NoiseGeneratorOctaves a;
   public NoiseGeneratorOctaves b;
   private World o;
   private double[] p;
   public MapGenNetherBridge c = new MapGenNetherBridge();
   private double[] q = new double[256];
   private double[] r = new double[256];
   private double[] s = new double[256];
   private MapGenBase t = new MapGenCavesHell();
   double[] d;
   double[] e;
   double[] f;
   double[] g;
   double[] h;

   public ChunkProviderHell(World par1World, long par2) {
      this.o = par1World;
      this.i = new Random(par2);
      this.j = new NoiseGeneratorOctaves(this.i, 16);
      this.k = new NoiseGeneratorOctaves(this.i, 16);
      this.l = new NoiseGeneratorOctaves(this.i, 8);
      this.m = new NoiseGeneratorOctaves(this.i, 4);
      this.n = new NoiseGeneratorOctaves(this.i, 4);
      this.a = new NoiseGeneratorOctaves(this.i, 10);
      this.b = new NoiseGeneratorOctaves(this.i, 16);
   }

   public void generateNetherTerrain(long par1, long par2, byte[] par3ArrayOfByte) {
      byte byte0 = 4;
      byte byte1 = 32;
      int i = byte0 + 1;
      byte byte2 = 17;
      int j = byte0 + 1;
      this.p = this.func_4057_a(this.p, par1 * byte0, 0, par2 * byte0, i, byte2, j);

      for (int k = 0; k < byte0; k++) {
         for (int l = 0; l < byte0; l++) {
            for (int i1 = 0; i1 < 16; i1++) {
               double d = 0.125;
               double d1 = this.p[((k + 0) * j + l + 0) * byte2 + i1 + 0];
               double d2 = this.p[((k + 0) * j + l + 1) * byte2 + i1 + 0];
               double d3 = this.p[((k + 1) * j + l + 0) * byte2 + i1 + 0];
               double d4 = this.p[((k + 1) * j + l + 1) * byte2 + i1 + 0];
               double d5 = (this.p[((k + 0) * j + l + 0) * byte2 + i1 + 1] - d1) * d;
               double d6 = (this.p[((k + 0) * j + l + 1) * byte2 + i1 + 1] - d2) * d;
               double d7 = (this.p[((k + 1) * j + l + 0) * byte2 + i1 + 1] - d3) * d;
               double d8 = (this.p[((k + 1) * j + l + 1) * byte2 + i1 + 1] - d4) * d;

               for (int j1 = 0; j1 < 8; j1++) {
                  double d9 = 0.25;
                  double d10 = d1;
                  double d11 = d2;
                  double d12 = (d3 - d1) * d9;
                  double d13 = (d4 - d2) * d9;

                  for (int k1 = 0; k1 < 4; k1++) {
                     int l1 = k1 + k * 4 << 11 | 0 + l * 4 << 7 | i1 * 8 + j1;
                     char c = 128;
                     double d14 = 0.25;
                     double d15 = d10;
                     double d16 = (d11 - d10) * d14;

                     for (int i2 = 0; i2 < 4; i2++) {
                        int j2 = 0;
                        if (i1 * 8 + j1 < byte1) {
                           j2 = Block.D.bO;
                        }

                        if (d15 > 0.0) {
                           j2 = Block.ItemBucket.bO;
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

   public void func_4058_b(long par1, long par2, byte[] par3ArrayOfByte) {
      byte byte0 = 64;
      double d = 0.03125;
      this.q = this.m.generateNoiseOctaves(this.q, par1 * 16L, par2 * 16L, 0L, 16, 16, 1, d, d, 1.0);
      this.r = this.m.generateNoiseOctaves(this.r, par1 * 16L, 109L, par2 * 16L, 16, 1, 16, d, 1.0, d);
      this.s = this.n.generateNoiseOctaves(this.s, par1 * 16L, par2 * 16L, 0L, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);

      for (int i = 0; i < 16; i++) {
         for (int j = 0; j < 16; j++) {
            boolean flag = this.q[i + j * 16] + this.i.nextDouble() * 0.2 > 0.0;
            boolean flag1 = this.r[i + j * 16] + this.i.nextDouble() * 0.2 > 0.0;
            int k = (int)(this.s[i + j * 16] / 3.0 + 3.0 + this.i.nextDouble() * 0.25);
            int l = -1;
            byte byte1 = (byte)Block.ItemBucket.bO;
            byte byte2 = (byte)Block.ItemBucket.bO;

            for (int i1 = 127; i1 >= 0; i1--) {
               int j1 = (j * 16 + i) * 128 + i1;
               if (i1 >= 127 - this.i.nextInt(5)) {
                  par3ArrayOfByte[j1] = (byte)Block.z.bO;
               } else if (i1 <= 0 + this.i.nextInt(5)) {
                  par3ArrayOfByte[j1] = (byte)Block.z.bO;
               } else {
                  byte byte3 = par3ArrayOfByte[j1];
                  if (byte3 == 0) {
                     l = -1;
                  } else if (byte3 == Block.ItemBucket.bO) {
                     if (l == -1) {
                        if (k <= 0) {
                           byte1 = 0;
                           byte2 = (byte)Block.ItemBucket.bO;
                        } else if (i1 >= byte0 - 4 && i1 <= byte0 + 1) {
                           byte1 = (byte)Block.ItemBucket.bO;
                           byte2 = (byte)Block.ItemBucket.bO;
                           if (flag1) {
                              byte1 = (byte)Block.F.bO;
                           }

                           if (flag1) {
                              byte2 = (byte)Block.ItemBucket.bO;
                           }

                           if (flag) {
                              byte1 = (byte)Block.EntityAnimal.bO;
                           }

                           if (flag) {
                              byte2 = (byte)Block.EntityAnimal.bO;
                           }
                        }

                        if (i1 < byte0 && byte1 == 0) {
                           byte1 = (byte)Block.D.bO;
                        }

                        l = k;
                        if (i1 >= byte0 - 1) {
                           par3ArrayOfByte[j1] = byte1;
                        } else {
                           par3ArrayOfByte[j1] = byte2;
                        }
                     } else if (l > 0) {
                        l--;
                        par3ArrayOfByte[j1] = byte2;
                     }
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
      this.generateNetherTerrain(par1, par2, abyte0);
      this.func_4058_b(par1, par2, abyte0);
      this.t.generate(this, this.o, par1, par2, abyte0);
      this.c.generate(this, this.o, par1, par2, abyte0);
      Chunk chunk = new Chunk(this.o, abyte0, par1, par2);
      BiomeGenBase[] abiomegenbase = this.o.i().loadBlockGeneratorData(null, par1 * 16L, par2 * 16L, 16, 16);
      byte[] abyte1 = chunk.m();

      for (int i = 0; i < abyte1.length; i++) {
         abyte1[i] = (byte)abiomegenbase[i].M;
      }

      chunk.n();
      return chunk;
   }

   private double[] func_4057_a(double[] par1ArrayOfDouble, long par2, int par3, long par4, int par5, int par6, int par7) {
      if (par1ArrayOfDouble == null) {
         par1ArrayOfDouble = new double[par5 * par6 * par7];
      }

      double d = 684.412;
      double d1 = 2053.236;
      this.g = this.a.generateNoiseOctaves(this.g, par2, par3, par4, par5, 1, par7, 1.0, 0.0, 1.0);
      this.h = this.b.generateNoiseOctaves(this.h, par2, par3, par4, par5, 1, par7, 100.0, 0.0, 100.0);
      this.d = this.l.generateNoiseOctaves(this.d, par2, par3, par4, par5, par6, par7, d / 80.0, d1 / 60.0, d / 80.0);
      this.e = this.j.generateNoiseOctaves(this.e, par2, par3, par4, par5, par6, par7, d, d1, d);
      this.f = this.k.generateNoiseOctaves(this.f, par2, par3, par4, par5, par6, par7, d, d1, d);
      int i = 0;
      int j = 0;
      double[] ad = new double[par6];

      for (int k = 0; k < par6; k++) {
         ad[k] = Math.cos(k * Math.PI * 6.0 / par6) * 2.0;
         double d2 = k;
         if (k > par6 / 2) {
            d2 = par6 - 1 - k;
         }

         if (d2 < 4.0) {
            d2 = 4.0 - d2;
            ad[k] -= d2 * d2 * d2 * 10.0;
         }
      }

      for (int l = 0; l < par5; l++) {
         for (int i1 = 0; i1 < par7; i1++) {
            double d3 = (this.g[j] + 256.0) / 512.0;
            if (d3 > 1.0) {
               d3 = 1.0;
            }

            double d4 = 0.0;
            double d5 = this.h[j] / 8000.0;
            if (d5 < 0.0) {
               d5 = -d5;
            }

            d5 = d5 * 3.0 - 3.0;
            if (d5 < 0.0) {
               d5 /= 2.0;
               if (d5 < -1.0) {
                  d5 = -1.0;
               }

               d5 /= 1.4;
               d5 /= 2.0;
               d3 = 0.0;
            } else {
               if (d5 > 1.0) {
                  d5 = 1.0;
               }

               d5 /= 6.0;
            }

            d3 += 0.5;
            d5 = d5 * par6 / 16.0;
            j++;

            for (int j1 = 0; j1 < par6; j1++) {
               double d6 = 0.0;
               double d7 = ad[j1];
               double d8 = this.e[i] / 512.0;
               double d9 = this.f[i] / 512.0;
               double d10 = (this.d[i] / 10.0 + 1.0) / 2.0;
               if (d10 < 0.0) {
                  d6 = d8;
               } else if (d10 > 1.0) {
                  d6 = d9;
               } else {
                  d6 = d8 + (d9 - d8) * d10;
               }

               d6 -= d7;
               if (j1 > par6 - 4) {
                  double d11 = (j1 - (par6 - 4)) / 3.0F;
                  d6 = d6 * (1.0 - d11) + -10.0 * d11;
               }

               if (j1 < d4) {
                  double d12 = (d4 - j1) / 4.0;
                  if (d12 < 0.0) {
                     d12 = 0.0;
                  }

                  if (d12 > 1.0) {
                     d12 = 1.0;
                  }

                  d6 = d6 * (1.0 - d12) + -10.0 * d12;
               }

               par1ArrayOfDouble[i] = d6;
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
      this.c.generateStructuresInChunk(this.o, this.i, par2, par3);

      for (int k = 0; k < 8; k++) {
         long i1 = i + this.i.nextInt(16) + 8L;
         int k2 = this.i.nextInt(120) + 4;
         long i4 = j + this.i.nextInt(16) + 8L;
         new WorldGenHellLava(Block.C.bO).generate(this.o, this.i, i1, k2, i4);
      }

      int l = this.i.nextInt(this.i.nextInt(10) + 1) + 1;

      for (int j1 = 0; j1 < l; j1++) {
         long l2 = i + this.i.nextInt(16) + 8L;
         int j4 = this.i.nextInt(120) + 4;
         long k5 = j + this.i.nextInt(16) + 8L;
         new WorldGenFire().generate(this.o, this.i, l2, j4, k5);
      }

      l = this.i.nextInt(this.i.nextInt(10) + 1);

      for (int k1 = 0; k1 < l; k1++) {
         long i3 = i + this.i.nextInt(16) + 8L;
         int k4 = this.i.nextInt(120) + 4;
         long l5 = j + this.i.nextInt(16) + 8L;
         new WorldGenGlowStone1().generate(this.o, this.i, i3, k4, l5);
      }

      for (int l1 = 0; l1 < 10; l1++) {
         long j3 = i + this.i.nextInt(16) + 8L;
         int l4 = this.i.nextInt(128);
         long i6 = j + this.i.nextInt(16) + 8L;
         new WorldGenGlowStone2().generate(this.o, this.i, j3, l4, i6);
      }

      if (this.i.nextInt(1) == 0) {
         long i2 = i + this.i.nextInt(16) + 8L;
         int k3 = this.i.nextInt(128);
         long i5 = j + this.i.nextInt(16) + 8L;
         new WorldGenFlowers(Block.TileEntityMobSpawnerRenderer.bO).generate(this.o, this.i, i2, k3, i5);
      }

      if (this.i.nextInt(1) == 0) {
         long j2 = i + this.i.nextInt(16) + 8L;
         int l3 = this.i.nextInt(128);
         long j5 = j + this.i.nextInt(16) + 8L;
         new WorldGenFlowers(Block.ag.bO).generate(this.o, this.i, j2, l3, j5);
      }

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
      return "HellRandomLevelSource";
   }

   @Override
   public List getPossibleCreatures(acf par1EnumCreatureType, long par2, int par3, long par4) {
      if (par1EnumCreatureType == acf.a && this.c.func_40483_a(par2, par3, par4)) {
         return this.c.b();
      }

      BiomeGenBase biomegenbase = this.o.getBiomeGenForCoords(par2, par4);
      return biomegenbase == null ? null : biomegenbase.a(par1EnumCreatureType);
   }

   @Override
   public ChunkPosition findClosestStructure(World par1World, String par2Str, long par3, int i, long j) {
      return null;
   }
}
