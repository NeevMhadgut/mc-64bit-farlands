import java.util.List;
import java.util.Random;

public class ChunkProviderGenerate implements IChunkProvider {
   private Random k;
   private NoiseGeneratorOctaves l;
   private NoiseGeneratorOctaves m;
   private NoiseGeneratorOctaves n;
   private NoiseGeneratorOctaves o;
   public NoiseGeneratorOctaves a;
   public NoiseGeneratorOctaves b;
   public NoiseGeneratorOctaves c;
   private World p;
   private final boolean q;
   private double[] r;
   private double[] s = new double[256];
   private MapGenBase t = new MapGenCaves();
   private MapGenStronghold u = new MapGenStronghold();
   private MapGenVillage v = new MapGenVillage(0);
   private MapGenMineshaft w = new MapGenMineshaft();
   private MapGenBase x = new MapGenRavine();
   private BiomeGenBase[] y;
   double[] d;
   double[] e;
   double[] f;
   double[] g;
   double[] h;
   float[] i;
   int[][] j = new int[32][32];

   public ChunkProviderGenerate(World par1World, long par2, boolean par4) {
      this.p = par1World;
      this.q = par4;
      this.k = new Random(par2);
      this.l = new NoiseGeneratorOctaves(this.k, 16);
      this.m = new NoiseGeneratorOctaves(this.k, 16);
      this.n = new NoiseGeneratorOctaves(this.k, 8);
      this.o = new NoiseGeneratorOctaves(this.k, 4);
      this.a = new NoiseGeneratorOctaves(this.k, 10);
      this.b = new NoiseGeneratorOctaves(this.k, 16);
      this.c = new NoiseGeneratorOctaves(this.k, 8);
   }

   public void generateTerrain(long par1, long par2, byte[] par3ArrayOfByte) {
      byte byte0 = 4;
      byte byte1 = 16;
      byte byte2 = 63;
      int i = byte0 + 1;
      byte byte3 = 17;
      int j = byte0 + 1;
      this.y = this.p.i().getBiomesForGeneration(this.y, par1 * 4L - 2L, par2 * 4L - 2L, i + 5, j + 5);
      this.r = this.initializeNoiseField(this.r, par1 * 4L, 0, par2 * 4L, i, byte3, j);

      for (int k = 0; k < byte0; k++) {
         for (int l = 0; l < byte0; l++) {
            for (int i1 = 0; i1 < byte1; i1++) {
               double d = 0.125;
               double d1 = this.r[((k + 0) * j + l + 0) * byte3 + i1 + 0];
               double d2 = this.r[((k + 0) * j + l + 1) * byte3 + i1 + 0];
               double d3 = this.r[((k + 1) * j + l + 0) * byte3 + i1 + 0];
               double d4 = this.r[((k + 1) * j + l + 1) * byte3 + i1 + 0];
               double d5 = (this.r[((k + 0) * j + l + 0) * byte3 + i1 + 1] - d1) * d;
               double d6 = (this.r[((k + 0) * j + l + 1) * byte3 + i1 + 1] - d2) * d;
               double d7 = (this.r[((k + 1) * j + l + 0) * byte3 + i1 + 1] - d3) * d;
               double d8 = (this.r[((k + 1) * j + l + 1) * byte3 + i1 + 1] - d4) * d;

               for (int j1 = 0; j1 < 8; j1++) {
                  double d9 = 0.25;
                  double d10 = d1;
                  double d11 = d2;
                  double d12 = (d3 - d1) * d9;
                  double d13 = (d4 - d2) * d9;

                  for (int k1 = 0; k1 < 4; k1++) {
                     int l1 = k1 + k * 4 << 11 | 0 + l * 4 << 7 | i1 * 8 + j1;
                     char c = 128;
                     l1 -= c;
                     double d14 = 0.25;
                     double d15 = d10;
                     double d16 = (d11 - d10) * d14;
                     d15 -= d16;

                     for (int i2 = 0; i2 < 4; i2++) {
                        if ((d15 += d16) > 0.0) {
                           par3ArrayOfByte[l1 += c] = (byte)Block.t.bO;
                        } else if (i1 * 8 + j1 <= byte2) {
                           par3ArrayOfByte[l1 += c] = (byte)Block.B.bO;
                        } else {
                           par3ArrayOfByte[l1 += c] = 0;
                        }
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

   public void replaceBlocksForBiome(long par1, long par2, byte[] par3ArrayOfByte, BiomeGenBase[] par4ArrayOfBiomeGenBase) {
      byte byte0 = 63;
      double d = 0.03125;
      this.s = this.o.generateNoiseOctaves(this.s, par1 * 16L, par2 * 16L, 0L, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);

      for (int i = 0; i < 16; i++) {
         for (int j = 0; j < 16; j++) {
            BiomeGenBase biomegenbase = par4ArrayOfBiomeGenBase[j + i * 16];
            float f = biomegenbase.j();
            int k = (int)(this.s[i + j * 16] / 3.0 + 3.0 + this.k.nextDouble() * 0.25);
            int l = -1;
            byte byte1 = biomegenbase.A;
            byte byte2 = biomegenbase.B;

            for (int i1 = 127; i1 >= 0; i1--) {
               int j1 = (j * 16 + i) * 128 + i1;
               if (i1 <= 0 + this.k.nextInt(5)) {
                  par3ArrayOfByte[j1] = (byte)Block.z.bO;
               } else {
                  byte byte3 = par3ArrayOfByte[j1];
                  if (byte3 == 0) {
                     l = -1;
                  } else if (byte3 == Block.t.bO) {
                     if (l == -1) {
                        if (k <= 0) {
                           byte1 = 0;
                           byte2 = (byte)Block.t.bO;
                        } else if (i1 >= byte0 - 3 && i1 <= byte0 + 2) {
                           if (i1 <= 66 && i1 >= 61) {
                              byte1 = (byte)Block.E.bO;
                              byte2 = (byte)Block.E.bO;
                           } else {
                              byte1 = biomegenbase.A;
                              byte2 = biomegenbase.B;
                           }
                        }

                        if (i1 <= byte0 && byte1 == 0) {
                           if (f < 0.15F) {
                              byte1 = (byte)Block.aT.bO;
                           } else {
                              byte1 = (byte)Block.B.bO;
                           }
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
                        if (l == 0 && byte2 == Block.E.bO) {
                           l = this.k.nextInt(4);
                           byte2 = (byte)Block.Q.bO;
                        }
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
      this.k.setSeed(par1 * 341873128712L + par2 * 132897987541L);
      byte[] abyte0 = new byte[32768];
      this.generateTerrain(par1, par2, abyte0);
      this.y = this.p.i().loadBlockGeneratorData(this.y, par1 * 16L, par2 * 16L, 16, 16);
      this.replaceBlocksForBiome(par1, par2, abyte0, this.y);
      this.t.generate(this, this.p, par1, par2, abyte0);
      this.x.generate(this, this.p, par1, par2, abyte0);
      if (this.q) {
         this.w.generate(this, this.p, par1, par2, abyte0);
         this.v.generate(this, this.p, par1, par2, abyte0);
         this.u.generate(this, this.p, par1, par2, abyte0);
      }

      Chunk chunk = new Chunk(this.p, abyte0, par1, par2);
      byte[] abyte1 = chunk.m();

      for (int i = 0; i < abyte1.length; i++) {
         abyte1[i] = (byte)this.y[i].M;
      }

      chunk.b();
      return chunk;
   }

   private double[] initializeNoiseField(double[] par1ArrayOfDouble, long par2, int par3, long par4, int par5, int par6, int par7) {
      if (par1ArrayOfDouble == null) {
         par1ArrayOfDouble = new double[par5 * par6 * par7];
      }

      if (this.i == null) {
         this.i = new float[25];

         for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
               float f = 10.0F / MathHelper.c(i * i + j * j + 0.2F);
               this.i[i + 2 + (j + 2) * 5] = f;
            }
         }
      }

      double d = 684.412;
      double d1 = 684.412;
      this.g = this.a.generateNoiseOctaves(this.g, par2, par4, par5, par7, 1.121, 1.121, 0.5);
      this.h = this.b.generateNoiseOctaves(this.h, par2, par4, par5, par7, 200.0, 200.0, 0.5);
      this.d = this.n.generateNoiseOctaves(this.d, par2, par3, par4, par5, par6, par7, d / 80.0, d1 / 160.0, d / 80.0);
      this.e = this.l.generateNoiseOctaves(this.e, par2, par3, par4, par5, par6, par7, d, d1, d);
      this.f = this.m.generateNoiseOctaves(this.f, par2, par3, par4, par5, par6, par7, d, d1, d);
      par4 = 0L;
      par2 = 0L;
      int k = 0;
      int l = 0;

      for (int i1 = 0; i1 < par5; i1++) {
         for (int j1 = 0; j1 < par7; j1++) {
            float f1 = 0.0F;
            float f2 = 0.0F;
            float f3 = 0.0F;
            byte byte0 = 2;
            BiomeGenBase biomegenbase = this.y[i1 + 2 + (j1 + 2) * (par5 + 5)];

            for (int k1 = -byte0; k1 <= byte0; k1++) {
               for (int l1 = -byte0; l1 <= byte0; l1++) {
                  BiomeGenBase biomegenbase1 = this.y[i1 + k1 + 2 + (j1 + l1 + 2) * (par5 + 5)];
                  float f4 = this.i[k1 + 2 + (l1 + 2) * 5] / (biomegenbase1.D + 2.0F);
                  if (biomegenbase1.D > biomegenbase.D) {
                     f4 /= 2.0F;
                  }

                  f1 += biomegenbase1.E * f4;
                  f2 += biomegenbase1.D * f4;
                  f3 += f4;
               }
            }

            f1 /= f3;
            f2 /= f3;
            f1 = f1 * 0.9F + 0.1F;
            f2 = (f2 * 4.0F - 1.0F) / 8.0F;
            double d2 = this.h[l] / 8000.0;
            if (d2 < 0.0) {
               d2 = -d2 * 0.3;
            }

            d2 = d2 * 3.0 - 2.0;
            if (d2 < 0.0) {
               d2 /= 2.0;
               if (d2 < -1.0) {
                  d2 = -1.0;
               }

               d2 /= 1.4;
               d2 /= 2.0;
            } else {
               if (d2 > 1.0) {
                  d2 = 1.0;
               }

               d2 /= 8.0;
            }

            l++;

            for (int i2 = 0; i2 < par6; i2++) {
               double d3 = f2;
               double d4 = f1;
               d3 += d2 * 0.2;
               d3 = d3 * par6 / 16.0;
               double d5 = par6 / 2.0 + d3 * 4.0;
               double d6 = 0.0;
               double d7 = (i2 - d5) * 12.0 * 128.0 / 128.0 / d4;
               if (d7 < 0.0) {
                  d7 *= 4.0;
               }

               double d8 = this.e[k] / 512.0;
               double d9 = this.f[k] / 512.0;
               double d10 = (this.d[k] / 10.0 + 1.0) / 2.0;
               if (d10 < 0.0) {
                  d6 = d8;
               } else if (d10 > 1.0) {
                  d6 = d9;
               } else {
                  d6 = d8 + (d9 - d8) * d10;
               }

               d6 -= d7;
               if (i2 > par6 - 4) {
                  double d11 = (i2 - (par6 - 4)) / 3.0;
                  d6 = d6 * (1.0 - d11) + -10.0 * d11;
               }

               par1ArrayOfDouble[k] = d6;
               k++;
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
      BiomeGenBase biomegenbase = this.p.getBiomeGenForCoords(i + 16L, j + 16L);
      this.k.setSeed(this.p.v());
      long l = this.k.nextLong() / 2L * 2L + 1L;
      long l1 = this.k.nextLong() / 2L * 2L + 1L;
      this.k.setSeed(par2 * l + par3 * l1 ^ this.p.v());
      boolean flag = false;
      if (this.q) {
         this.w.generateStructuresInChunk(this.p, this.k, par2, par3);
         flag = this.v.generateStructuresInChunk(this.p, this.k, par2, par3);
         this.u.generateStructuresInChunk(this.p, this.k, par2, par3);
      }

      if (!flag && this.k.nextInt(4) == 0) {
         long k = i + this.k.nextInt(16) + 8L;
         int i2 = this.k.nextInt(128);
         long i3 = j + this.k.nextInt(16) + 8L;
         new WorldGenLakes(Block.B.bO).generate(this.p, this.k, k, i2, i3);
      }

      if (!flag && this.k.nextInt(8) == 0) {
         long i1 = i + this.k.nextInt(16) + 8L;
         int j2 = this.k.nextInt(this.k.nextInt(120) + 8);
         long j3 = j + this.k.nextInt(16) + 8L;
         if (j2 < 63 || this.k.nextInt(10) == 0) {
            new WorldGenLakes(Block.D.bO).generate(this.p, this.k, i1, j2, j3);
         }
      }

      for (int j1 = 0; j1 < 8; j1++) {
         long k2 = i + this.k.nextInt(16) + 8L;
         int k3 = this.k.nextInt(128);
         long i4 = j + this.k.nextInt(16) + 8L;
         if (!new WorldGenDungeons().generate(this.p, this.k, k2, k3, i4)) {
         }
      }

      biomegenbase.decorate(this.p, this.k, i, j);
      SpawnerAnimals.performWorldGenSpawning(this.p, biomegenbase, i + 8L, j + 8L, 16, 16, this.k);
      i += 8L;
      j += 8L;

      for (int k1 = 0; k1 < 16; k1++) {
         for (int l2 = 0; l2 < 16; l2++) {
            int l3 = this.p.getPrecipitationHeight(i + k1, j + l2);
            if (this.p.isBlockHydratedDirectly(k1 + i, l3 - 1, l2 + j)) {
               this.p.setBlockWithNotify(k1 + i, l3 - 1, l2 + j, Block.aT.bO);
            }

            if (this.p.canSnowAt(k1 + i, l3, l2 + j)) {
               this.p.setBlockWithNotify(k1 + i, l3, l2 + j, Block.aS.bO);
            }
         }
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
      return "RandomLevelSource";
   }

   @Override
   public List getPossibleCreatures(acf par1EnumCreatureType, long par2, int par3, long par4) {
      BiomeGenBase biomegenbase = this.p.getBiomeGenForCoords(par2, par4);
      return biomegenbase == null ? null : biomegenbase.a(par1EnumCreatureType);
   }

   @Override
   public ChunkPosition findClosestStructure(World par1World, String par2Str, long par3, int par4, long par5) {
      return "Stronghold".equals(par2Str) && this.u != null ? this.u.getNearestInstance(par1World, par3, par4, par5) : null;
   }
}
