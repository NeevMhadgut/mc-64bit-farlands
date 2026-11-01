public class ChunkLoader {
   public static AnvilConverterData a(ady par0NBTTagCompound) {
      long i;
      try {
         i = par0NBTTagCompound.g("xPos");
      } catch (ClassCastException ex) {
         i = par0NBTTagCompound.f("xPos");
      }

      long j;
      try {
         j = par0NBTTagCompound.g("zPos");
      } catch (ClassCastException ex) {
         j = par0NBTTagCompound.f("zPos");
      }

      AnvilConverterData anvilconverterdata = new AnvilConverterData(i, j);
      anvilconverterdata.g = par0NBTTagCompound.k("Blocks");
      anvilconverterdata.f = new pd(par0NBTTagCompound.k("Data"), 7);
      anvilconverterdata.e = new pd(par0NBTTagCompound.k("SkyLight"), 7);
      anvilconverterdata.d = new pd(par0NBTTagCompound.k("BlockLight"), 7);
      anvilconverterdata.c = par0NBTTagCompound.k("HeightMap");
      anvilconverterdata.b = par0NBTTagCompound.o("TerrainPopulated");
      anvilconverterdata.h = par0NBTTagCompound.n("Entities");
      anvilconverterdata.i = par0NBTTagCompound.n("TileEntities");
      anvilconverterdata.j = par0NBTTagCompound.n("TileTicks");

      try {
         anvilconverterdata.a = par0NBTTagCompound.g("LastUpdate");
      } catch (ClassCastException classcastexception) {
         anvilconverterdata.a = par0NBTTagCompound.f("LastUpdate");
      }

      return anvilconverterdata;
   }

   public static void a(AnvilConverterData par0AnvilConverterData, ady par1NBTTagCompound, WorldChunkManager par2WorldChunkManager) {
      par1NBTTagCompound.a("xPos", par0AnvilConverterData.k);
      par1NBTTagCompound.a("zPos", par0AnvilConverterData.l);
      par1NBTTagCompound.a("LastUpdate", par0AnvilConverterData.a);
      int[] ai = new int[par0AnvilConverterData.c.length];

      for (int i = 0; i < par0AnvilConverterData.c.length; i++) {
         ai[i] = par0AnvilConverterData.c[i];
      }

      par1NBTTagCompound.a("HeightMap", ai);
      par1NBTTagCompound.a("TerrainPopulated", par0AnvilConverterData.b);
      no nbttaglist = new no("Sections");

      for (int j = 0; j < 8; j++) {
         boolean flag = true;

         for (int l = 0; l < 16 && flag; l++) {
            for (int j1 = 0; j1 < 16 && flag; j1++) {
               for (int k1 = 0; k1 < 16; k1++) {
                  int l1 = l << 11 | k1 << 7 | j1 + (j << 4);
                  byte byte0 = par0AnvilConverterData.g[l1];
                  if (byte0 != 0) {
                     flag = false;
                     break;
                  }
               }
            }
         }

         if (!flag) {
            byte[] abyte1 = new byte[4096];
            qq nibblearray = new qq(abyte1.length, 4);
            qq nibblearray1 = new qq(abyte1.length, 4);
            qq nibblearray2 = new qq(abyte1.length, 4);

            for (int i2 = 0; i2 < 16; i2++) {
               for (int j2 = 0; j2 < 16; j2++) {
                  for (int k2 = 0; k2 < 16; k2++) {
                     int l2 = i2 << 11 | k2 << 7 | j2 + (j << 4);
                     byte byte1 = par0AnvilConverterData.g[l2];
                     abyte1[j2 << 8 | k2 << 4 | i2] = (byte)(byte1 & 0xFF);
                     nibblearray.a(i2, j2, k2, par0AnvilConverterData.f.a(i2, j2 + (j << 4), k2));
                     nibblearray1.a(i2, j2, k2, par0AnvilConverterData.e.a(i2, j2 + (j << 4), k2));
                     nibblearray2.a(i2, j2, k2, par0AnvilConverterData.d.a(i2, j2 + (j << 4), k2));
                  }
               }
            }

            ady nbttagcompound = new ady();
            nbttagcompound.a("Y", (byte)(j & 0xFF));
            nbttagcompound.a("Blocks", abyte1);
            nbttagcompound.a("Data", nibblearray.a);
            nbttagcompound.a("SkyLight", nibblearray1.a);
            nbttagcompound.a("BlockLight", nibblearray2.a);
            nbttaglist.a(nbttagcompound);
         }
      }

      par1NBTTagCompound.a("Sections", nbttaglist);
      byte[] abyte0 = new byte[256];

      for (int k = 0; k < 16; k++) {
         for (int i1 = 0; i1 < 16; i1++) {
            abyte0[i1 << 4 | k] = (byte)(par2WorldChunkManager.getBiomeGenAt(par0AnvilConverterData.k << 4 | k, par0AnvilConverterData.l << 4 | i1).M & 0xFF);
         }
      }

      par1NBTTagCompound.a("Biomes", abyte0);
      par1NBTTagCompound.a("Entities", par0AnvilConverterData.h);
      par1NBTTagCompound.a("TileEntities", par0AnvilConverterData.i);
      if (par0AnvilConverterData.j != null) {
         par1NBTTagCompound.a("TileTicks", par0AnvilConverterData.j);
      }
   }
}
