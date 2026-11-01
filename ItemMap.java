public class ItemMap extends ve {
   protected ItemMap(int par1) {
      super(par1);
      this.f(1);
   }

   public static MapData a(short par0, World par1World) {
      String s = "map_" + par0;
      MapData mapdata = (MapData)par1World.a(MapData.class, "map_" + par0);
      if (mapdata == null) {
         int i = par1World.b("map");
         String s1 = "map_" + i;
         mapdata = new MapData(s1);
         par1World.a(s1, mapdata);
      }

      return mapdata;
   }

   public MapData a(ItemStack par1ItemStack, World par2World) {
      String s = "map_" + par1ItemStack.i();
      MapData mapdata = (MapData)par2World.a(MapData.class, "map_" + par1ItemStack.i());
      if (mapdata == null) {
         par1ItemStack.b(par2World.b("map"));
         String s1 = "map_" + par1ItemStack.i();
         mapdata = new MapData(s1);
         mapdata.b = par2World.B().getSpawnX();
         mapdata.c = par2World.B().getSpawnZ();
         mapdata.e = 3;
         mapdata.d = (byte)par2World.t.g;
         mapdata.a();
         par2World.a(s1, mapdata);
      }

      return mapdata;
   }

   public void a(World par1World, Entity par2Entity, MapData par3MapData) {
      if (par1World.t.g == par3MapData.d) {
         char c = 128;
         char c1 = 128;
         int i = 1 << par3MapData.e;
         long j = par3MapData.b;
         long k = par3MapData.c;
         int l = (int)(MathHelper.d(par2Entity.o - j) / i + c / 2);
         int i1 = (int)(MathHelper.d(par2Entity.q - k) / i + c1 / 2);
         int j1 = 128 / i;
         if (par1World.t.e) {
            j1 /= 2;
         }

         par3MapData.g++;

         for (int k1 = l - j1 + 1; k1 < l + j1; k1++) {
            if ((k1 & 15) == (par3MapData.g & 15)) {
               int l1 = 255;
               int i2 = 0;
               double d = 0.0;

               for (int j2 = i1 - j1 - 1; j2 < i1 + j1; j2++) {
                  if (k1 >= 0 && j2 >= -1 && k1 < c && j2 < c1) {
                     long k2 = k1 - l;
                     long l2 = j2 - i1;
                     boolean flag = k2 * k2 + l2 * l2 > (j1 - 2) * (j1 - 2);
                     long i3 = (j / i + k1 - c / 2) * i;
                     long j3 = (k / i + j2 - c1 / 2) * i;
                     int k3 = 0;
                     int l3 = 0;
                     int i4 = 0;
                     int[] ai = new int[256];
                     Chunk chunk = par1World.getChunkFromBlockCoords(i3, j3);
                     int j4 = (int)(i3 & 15L);
                     int k4 = (int)(j3 & 15L);
                     int l4 = 0;
                     double d1 = 0.0;
                     if (par1World.t.e) {
                        long i5 = i3 + j3 * 231871L;
                        i5 = i5 * i5 * 31287121L + i5 * 11L;
                        if ((i5 >> 20 & 1L) == 0L) {
                           ai[Block.v.bO] = ai[Block.v.bO] + 10;
                        } else {
                           ai[Block.t.bO] = ai[Block.t.bO] + 10;
                        }

                        d1 = 100.0;
                     } else {
                        for (int j5 = 0; j5 < i; j5++) {
                           for (int l5 = 0; l5 < i; l5++) {
                              int j6 = chunk.b(j5 + j4, l5 + k4) + 1;
                              int l6 = 0;
                              if (j6 > 1) {
                                 boolean flag1 = false;

                                 do {
                                    flag1 = true;
                                    l6 = chunk.a(j5 + j4, j6 - 1, l5 + k4);
                                    if (l6 == 0) {
                                       flag1 = false;
                                    } else if (j6 > 0 && l6 > 0 && Block.m[l6].cd.F == wh.b) {
                                       flag1 = false;
                                    }

                                    if (!flag1) {
                                       j6--;
                                       l6 = chunk.a(j5 + j4, j6 - 1, l5 + k4);
                                    }
                                 } while (j6 > 0 && !flag1);

                                 if (j6 > 0 && l6 != 0 && Block.m[l6].cd.d()) {
                                    int i7 = j6 - 1;
                                    int k7 = 0;

                                    do {
                                       k7 = chunk.a(j5 + j4, i7--, l5 + k4);
                                       l4++;
                                    } while (i7 > 0 && k7 != 0 && Block.m[k7].cd.d());
                                 }
                              }

                              d1 += (double)j6 / (i * i);
                              ai[l6]++;
                           }
                        }
                     }

                     l4 /= i * i;
                     k3 /= i * i;
                     l3 /= i * i;
                     i4 /= i * i;
                     int k5 = 0;
                     int i6 = 0;

                     for (int k6 = 0; k6 < 256; k6++) {
                        if (ai[k6] > k5) {
                           i6 = k6;
                           k5 = ai[k6];
                        }
                     }

                     double d2 = (d1 - d) * 4.0 / (i + 4) + ((k1 + j2 & 1) - 0.5) * 0.4;
                     byte byte0 = 1;
                     if (d2 > 0.6) {
                        byte0 = 2;
                     }

                     if (d2 < -0.6) {
                        byte0 = 0;
                     }

                     int j7 = 0;
                     if (i6 > 0) {
                        wh mapcolor = Block.m[i6].cd.F;
                        if (mapcolor == wh.n) {
                           double d3 = l4 * 0.1 + (k1 + j2 & 1) * 0.2;
                           byte0 = 1;
                           if (d3 < 0.5) {
                              byte0 = 2;
                           }

                           if (d3 > 0.9) {
                              byte0 = 0;
                           }
                        }

                        j7 = mapcolor.q;
                     }

                     d = d1;
                     if (j2 >= 0 && k2 * k2 + l2 * l2 < j1 * j1 && (!flag || (k1 + j2 & 1) != 0)) {
                        byte byte1 = par3MapData.f[k1 + j2 * c];
                        byte byte2 = (byte)(j7 * 4 + byte0);
                        if (byte1 != byte2) {
                           if (l1 > j2) {
                              l1 = j2;
                           }

                           if (i2 < j2) {
                              i2 = j2;
                           }

                           par3MapData.f[k1 + j2 * c] = byte2;
                        }
                     }
                  }
               }

               if (l1 <= i2) {
                  par3MapData.a(k1, l1, i2);
               }
            }
         }
      }
   }

   public void a(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
      if (!par2World.F) {
         MapData mapdata = this.a(par1ItemStack, par2World);
         if (par3Entity instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer)par3Entity;
            mapdata.a(entityplayer, par1ItemStack);
         }

         if (par5) {
            this.a(par2World, par3Entity, mapdata);
         }
      }
   }

   public void c(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      par1ItemStack.b(par2World.b("map"));
      String s = "map_" + par1ItemStack.i();
      MapData mapdata = new MapData(s);
      par2World.a(s, mapdata);
      mapdata.b = MathHelper.d(par3EntityPlayer.o);
      mapdata.c = MathHelper.d(par3EntityPlayer.q);
      mapdata.e = 3;
      mapdata.d = (byte)par2World.t.g;
      mapdata.a();
   }
}
