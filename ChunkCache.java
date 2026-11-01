public class ChunkCache implements IBlockAccess {
   private long a;
   private long b;
   private Chunk[][] c;
   private boolean d;
   private World e;

   public ChunkCache(World par1World, long par2, int par3, long par4, long par5, int par6, long par7) {
      this.e = par1World;
      this.a = par2 >> 4;
      this.b = par4 >> 4;
      long i = par5 >> 4;
      long j = par7 >> 4;
      this.c = new Chunk[(int)(i - this.a) + 1][(int)(j - this.b) + 1];
      this.d = true;

      for (long k = this.a; k <= i; k++) {
         for (long l = this.b; l <= j; l++) {
            Chunk chunk = par1World.getChunkFromChunkCoords(k, l);
            if (chunk != null) {
               this.c[(int)(k - this.a)][(int)(l - this.b)] = chunk;
               if (!chunk.c(par3, par6)) {
                  this.d = false;
               }
            }
         }
      }
   }

   @Override
   public boolean a() {
      return this.d;
   }

   @Override
   public int getBlockId(long par1, int par2, long par3) {
      if (par2 < 0) {
         return 0;
      } else if (par2 >= 256) {
         return 0;
      } else {
         int i = (int)((par1 >> 4) - this.a);
         int j = (int)((par3 >> 4) - this.b);
         if (i >= 0 && i < this.c.length && j >= 0 && j < this.c[i].length) {
            Chunk chunk = this.c[i][j];
            return chunk == null ? 0 : chunk.a((int)(par1 & 15L), par2, (int)(par3 & 15L));
         } else {
            return 0;
         }
      }
   }

   @Override
   public TileEntity getBlockTileEntity(long par1, int par2, long par3) {
      int i = (int)((par1 >> 4) - this.a);
      int j = (int)((par3 >> 4) - this.b);
      return this.c[i][j].e((int)(par1 & 15L), par2, (int)(par3 & 15L));
   }

   @Override
   public float getBrightness(long par1, int par2, long par3, int par4) {
      int i = this.getLightValue(par1, par2, par3);
      if (i < par4) {
         i = par4;
      }

      return this.e.t.f[i];
   }

   @Override
   public int getLightBrightnessForSkyBlocks(long par1, int par2, long par3, int par4) {
      int i = this.getSkyBlockTypeBrightness(wl.a, par1, par2, par3);
      int j = this.getSkyBlockTypeBrightness(wl.b, par1, par2, par3);
      if (j < par4) {
         j = par4;
      }

      return i << 20 | j << 4;
   }

   @Override
   public float getLightBrightness(long par1, int par2, long par3) {
      return this.e.t.f[this.getLightValue(par1, par2, par3)];
   }

   public int getLightValue(long par1, int par2, long par3) {
      return this.getLightValueExt(par1, par2, par3, true);
   }

   public int getLightValueExt(long par1, int par2, long par3, boolean par4) {
      if (par4) {
         int i = this.getBlockId(par1, par2, par3);
         if (i == Block.ak.bO || i == Block.aA.bO || i == Block.at.bO || i == Block.aH.bO) {
            int l = this.getLightValueExt(par1, par2 + 1, par3, false);
            int j1 = this.getLightValueExt(par1 + 1L, par2, par3, false);
            int k1 = this.getLightValueExt(par1 - 1L, par2, par3, false);
            int l1 = this.getLightValueExt(par1, par2, par3 + 1L, false);
            int i2 = this.getLightValueExt(par1, par2, par3 - 1L, false);
            if (j1 > l) {
               l = j1;
            }

            if (k1 > l) {
               l = k1;
            }

            if (l1 > l) {
               l = l1;
            }

            if (i2 > l) {
               l = i2;
            }

            return l;
         }
      }

      if (par2 < 0) {
         return 0;
      }

      if (par2 >= 256) {
         int j = 15 - this.e.f;
         if (j < 0) {
            j = 0;
         }

         return j;
      } else {
         int k = (int)((par1 >> 4) - this.a);
         int i1 = (int)((par3 >> 4) - this.b);
         return this.c[k][i1].c((int)(par1 & 15L), par2, (int)(par3 & 15L), this.e.f);
      }
   }

   @Override
   public int getBlockMetadata(long par1, int par2, long par3) {
      if (par2 < 0) {
         return 0;
      }

      if (par2 >= 256) {
         return 0;
      }

      int i = (int)((par1 >> 4) - this.a);
      int j = (int)((par3 >> 4) - this.b);
      return this.c[i][j].c((int)(par1 & 15L), par2, (int)(par3 & 15L));
   }

   @Override
   public acn getBlockMaterial(long par1, int par2, long par3) {
      int i = this.getBlockId(par1, par2, par3);
      return i == 0 ? acn.a : Block.m[i].cd;
   }

   @Override
   public BiomeGenBase getBiomeGenForCoords(long par1, long par2) {
      return this.e.getBiomeGenForCoords(par1, par2);
   }

   @Override
   public boolean isBlockOpaqueCube(long par1, int par2, long par3) {
      Block block = Block.m[this.getBlockId(par1, par2, par3)];
      return block == null ? false : block.a();
   }

   @Override
   public boolean isBlockNormalCube(long par1, int par2, long par3) {
      Block block = Block.m[this.getBlockId(par1, par2, par3)];
      return block == null ? false : block.cd.c() && block.b();
   }

   @Override
   public boolean isAirBlock(long par1, int par2, long par3) {
      Block block = Block.m[this.getBlockId(par1, par2, par3)];
      return block == null;
   }

   public int getSkyBlockTypeBrightness(wl par1EnumSkyBlock, long par2, int par3, long par4) {
      if (par3 < 0) {
         par3 = 0;
      }

      if (par3 >= 256) {
         par3 = 255;
      }

      if (par3 >= 0 && par3 < 256) {
         if (Block.s[this.getBlockId(par2, par3, par4)]) {
            int i = this.getSpecialBlockBrightness(par1EnumSkyBlock, par2, par3 + 1, par4);
            int k = this.getSpecialBlockBrightness(par1EnumSkyBlock, par2 + 1L, par3, par4);
            int i1 = this.getSpecialBlockBrightness(par1EnumSkyBlock, par2 - 1L, par3, par4);
            int j1 = this.getSpecialBlockBrightness(par1EnumSkyBlock, par2, par3, par4 + 1L);
            int k1 = this.getSpecialBlockBrightness(par1EnumSkyBlock, par2, par3, par4 - 1L);
            if (k > i) {
               i = k;
            }

            if (i1 > i) {
               i = i1;
            }

            if (j1 > i) {
               i = j1;
            }

            if (k1 > i) {
               i = k1;
            }

            return i;
         } else {
            int j = (int)((par2 >> 4) - this.a);
            int l = (int)((par4 >> 4) - this.b);
            return this.c[j][l].a(par1EnumSkyBlock, (int)(par2 & 15L), par3, (int)(par4 & 15L));
         }
      } else {
         return par1EnumSkyBlock.c;
      }
   }

   public int getSpecialBlockBrightness(wl par1EnumSkyBlock, long par2, int par3, long par4) {
      if (par3 < 0) {
         par3 = 0;
      }

      if (par3 >= 256) {
         par3 = 255;
      }

      if (par3 >= 0 && par3 < 256) {
         int i = (int)((par2 >> 4) - this.a);
         int j = (int)((par4 >> 4) - this.b);
         return this.c[i][j].a(par1EnumSkyBlock, (int)(par2 & 15L), par3, (int)(par4 & 15L));
      } else {
         return par1EnumSkyBlock.c;
      }
   }

   @Override
   public int b() {
      return 256;
   }
}
