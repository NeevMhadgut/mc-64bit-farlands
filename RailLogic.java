import java.util.ArrayList;
import java.util.List;

class RailLogic {
   private World b;
   private long c;
   private int d;
   private long e;
   private final boolean f;
   private List g;
   final BlockRail a;

   public RailLogic(BlockRail par1BlockRail, World par2World, long par3, int par4, long par5) {
      this.a = par1BlockRail;
      this.g = new ArrayList();
      this.b = par2World;
      this.c = par3;
      this.d = par4;
      this.e = par5;
      int i = par2World.getBlockId(par3, par4, par5);
      int j = par2World.getBlockMetadata(par3, par4, par5);
      if (BlockRail.a((BlockRail)Block.m[i])) {
         this.f = true;
         j &= -9;
      } else {
         this.f = false;
      }

      this.a(j);
   }

   private void a(int par1) {
      this.g.clear();
      if (par1 == 0) {
         this.g.add(new ChunkPosition(this.c, this.d, this.e - 1L));
         this.g.add(new ChunkPosition(this.c, this.d, this.e + 1L));
      } else if (par1 == 1) {
         this.g.add(new ChunkPosition(this.c - 1L, this.d, this.e));
         this.g.add(new ChunkPosition(this.c + 1L, this.d, this.e));
      } else if (par1 == 2) {
         this.g.add(new ChunkPosition(this.c - 1L, this.d, this.e));
         this.g.add(new ChunkPosition(this.c + 1L, this.d + 1, this.e));
      } else if (par1 == 3) {
         this.g.add(new ChunkPosition(this.c - 1L, this.d + 1, this.e));
         this.g.add(new ChunkPosition(this.c + 1L, this.d, this.e));
      } else if (par1 == 4) {
         this.g.add(new ChunkPosition(this.c, this.d + 1, this.e - 1L));
         this.g.add(new ChunkPosition(this.c, this.d, this.e + 1L));
      } else if (par1 == 5) {
         this.g.add(new ChunkPosition(this.c, this.d, this.e - 1L));
         this.g.add(new ChunkPosition(this.c, this.d + 1, this.e + 1L));
      } else if (par1 == 6) {
         this.g.add(new ChunkPosition(this.c + 1L, this.d, this.e));
         this.g.add(new ChunkPosition(this.c, this.d, this.e + 1L));
      } else if (par1 == 7) {
         this.g.add(new ChunkPosition(this.c - 1L, this.d, this.e));
         this.g.add(new ChunkPosition(this.c, this.d, this.e + 1L));
      } else if (par1 == 8) {
         this.g.add(new ChunkPosition(this.c - 1L, this.d, this.e));
         this.g.add(new ChunkPosition(this.c, this.d, this.e - 1L));
      } else if (par1 == 9) {
         this.g.add(new ChunkPosition(this.c + 1L, this.d, this.e));
         this.g.add(new ChunkPosition(this.c, this.d, this.e - 1L));
      }
   }

   private void a() {
      for (int i = 0; i < this.g.size(); i++) {
         RailLogic raillogic = this.a((ChunkPosition)this.g.get(i));
         if (raillogic != null && raillogic.b(this)) {
            this.g.set(i, new ChunkPosition(raillogic.c, raillogic.d, raillogic.e));
         } else {
            this.g.remove(i--);
         }
      }
   }

   private boolean isMinecartTrack(long par1, int par2, long par3) {
      if (BlockRail.isRailBlockAt(this.b, par1, par2, par3)) {
         return true;
      } else {
         return BlockRail.isRailBlockAt(this.b, par1, par2 + 1, par3) ? true : BlockRail.isRailBlockAt(this.b, par1, par2 - 1, par3);
      }
   }

   private RailLogic a(ChunkPosition par1ChunkPosition) {
      if (BlockRail.isRailBlockAt(this.b, par1ChunkPosition.a, par1ChunkPosition.b, par1ChunkPosition.c)) {
         return new RailLogic(this.a, this.b, par1ChunkPosition.a, par1ChunkPosition.b, par1ChunkPosition.c);
      } else if (BlockRail.isRailBlockAt(this.b, par1ChunkPosition.a, par1ChunkPosition.b + 1, par1ChunkPosition.c)) {
         return new RailLogic(this.a, this.b, par1ChunkPosition.a, par1ChunkPosition.b + 1, par1ChunkPosition.c);
      } else {
         return BlockRail.isRailBlockAt(this.b, par1ChunkPosition.a, par1ChunkPosition.b - 1, par1ChunkPosition.c)
            ? new RailLogic(this.a, this.b, par1ChunkPosition.a, par1ChunkPosition.b - 1, par1ChunkPosition.c)
            : null;
      }
   }

   private boolean b(RailLogic par1RailLogic) {
      for (int i = 0; i < this.g.size(); i++) {
         ChunkPosition chunkposition = (ChunkPosition)this.g.get(i);
         if (chunkposition.a == par1RailLogic.c && chunkposition.c == par1RailLogic.e) {
            return true;
         }
      }

      return false;
   }

   private boolean isInTrack(long par1, int par2, long par3) {
      for (int i = 0; i < this.g.size(); i++) {
         ChunkPosition chunkposition = (ChunkPosition)this.g.get(i);
         if (chunkposition.a == par1 && chunkposition.c == par3) {
            return true;
         }
      }

      return false;
   }

   private int b() {
      int i = 0;
      if (this.isMinecartTrack(this.c, this.d, this.e - 1L)) {
         i++;
      }

      if (this.isMinecartTrack(this.c, this.d, this.e + 1L)) {
         i++;
      }

      if (this.isMinecartTrack(this.c - 1L, this.d, this.e)) {
         i++;
      }

      if (this.isMinecartTrack(this.c + 1L, this.d, this.e)) {
         i++;
      }

      return i;
   }

   private boolean c(RailLogic par1RailLogic) {
      if (this.b(par1RailLogic)) {
         return true;
      }

      if (this.g.size() == 2) {
         return false;
      }

      if (this.g.size() == 0) {
         return true;
      }

      ChunkPosition chunkposition = (ChunkPosition)this.g.get(0);
      return par1RailLogic.d == this.d && chunkposition.b == this.d ? true : true;
   }

   private void d(RailLogic par1RailLogic) {
      this.g.add(new ChunkPosition(par1RailLogic.c, par1RailLogic.d, par1RailLogic.e));
      boolean flag = this.isInTrack(this.c, this.d, this.e - 1L);
      boolean flag1 = this.isInTrack(this.c, this.d, this.e + 1L);
      boolean flag2 = this.isInTrack(this.c - 1L, this.d, this.e);
      boolean flag3 = this.isInTrack(this.c + 1L, this.d, this.e);
      byte byte0 = -1;
      if (flag || flag1) {
         byte0 = 0;
      }

      if (flag2 || flag3) {
         byte0 = 1;
      }

      if (!this.f) {
         if (flag1 && flag3 && !flag && !flag2) {
            byte0 = 6;
         }

         if (flag1 && flag2 && !flag && !flag3) {
            byte0 = 7;
         }

         if (flag && flag2 && !flag1 && !flag3) {
            byte0 = 8;
         }

         if (flag && flag3 && !flag1 && !flag2) {
            byte0 = 9;
         }
      }

      if (byte0 == 0) {
         if (BlockRail.isRailBlockAt(this.b, this.c, this.d + 1, this.e - 1L)) {
            byte0 = 4;
         }

         if (BlockRail.isRailBlockAt(this.b, this.c, this.d + 1, this.e + 1L)) {
            byte0 = 5;
         }
      }

      if (byte0 == 1) {
         if (BlockRail.isRailBlockAt(this.b, this.c + 1L, this.d + 1, this.e)) {
            byte0 = 2;
         }

         if (BlockRail.isRailBlockAt(this.b, this.c - 1L, this.d + 1, this.e)) {
            byte0 = 3;
         }
      }

      if (byte0 < 0) {
         byte0 = 0;
      }

      int i = byte0;
      if (this.f) {
         i = this.b.getBlockMetadata(this.c, this.d, this.e) & 8 | byte0;
      }

      this.b.setBlockMetadataWithNotify(this.c, this.d, this.e, i);
   }

   private boolean canConnectFrom(long par1, int par2, long par3) {
      RailLogic raillogic = this.a(new ChunkPosition(par1, par2, par3));
      if (raillogic == null) {
         return false;
      }

      raillogic.a();
      return raillogic.c(this);
   }

   public void a(boolean par1, boolean par2) {
      boolean flag = this.canConnectFrom(this.c, this.d, this.e - 1L);
      boolean flag1 = this.canConnectFrom(this.c, this.d, this.e + 1L);
      boolean flag2 = this.canConnectFrom(this.c - 1L, this.d, this.e);
      boolean flag3 = this.canConnectFrom(this.c + 1L, this.d, this.e);
      byte byte0 = -1;
      if ((flag || flag1) && !flag2 && !flag3) {
         byte0 = 0;
      }

      if ((flag2 || flag3) && !flag && !flag1) {
         byte0 = 1;
      }

      if (!this.f) {
         if (flag1 && flag3 && !flag && !flag2) {
            byte0 = 6;
         }

         if (flag1 && flag2 && !flag && !flag3) {
            byte0 = 7;
         }

         if (flag && flag2 && !flag1 && !flag3) {
            byte0 = 8;
         }

         if (flag && flag3 && !flag1 && !flag2) {
            byte0 = 9;
         }
      }

      if (byte0 == -1) {
         if (flag || flag1) {
            byte0 = 0;
         }

         if (flag2 || flag3) {
            byte0 = 1;
         }

         if (!this.f) {
            if (par1) {
               if (flag1 && flag3) {
                  byte0 = 6;
               }

               if (flag2 && flag1) {
                  byte0 = 7;
               }

               if (flag3 && flag) {
                  byte0 = 9;
               }

               if (flag && flag2) {
                  byte0 = 8;
               }
            } else {
               if (flag && flag2) {
                  byte0 = 8;
               }

               if (flag3 && flag) {
                  byte0 = 9;
               }

               if (flag2 && flag1) {
                  byte0 = 7;
               }

               if (flag1 && flag3) {
                  byte0 = 6;
               }
            }
         }
      }

      if (byte0 == 0) {
         if (BlockRail.isRailBlockAt(this.b, this.c, this.d + 1, this.e - 1L)) {
            byte0 = 4;
         }

         if (BlockRail.isRailBlockAt(this.b, this.c, this.d + 1, this.e + 1L)) {
            byte0 = 5;
         }
      }

      if (byte0 == 1) {
         if (BlockRail.isRailBlockAt(this.b, this.c + 1L, this.d + 1, this.e)) {
            byte0 = 2;
         }

         if (BlockRail.isRailBlockAt(this.b, this.c - 1L, this.d + 1, this.e)) {
            byte0 = 3;
         }
      }

      if (byte0 < 0) {
         byte0 = 0;
      }

      this.a(byte0);
      int i = byte0;
      if (this.f) {
         i = this.b.getBlockMetadata(this.c, this.d, this.e) & 8 | byte0;
      }

      if (par2 || this.b.getBlockMetadata(this.c, this.d, this.e) != i) {
         this.b.setBlockMetadataWithNotify(this.c, this.d, this.e, i);

         for (int j = 0; j < this.g.size(); j++) {
            RailLogic raillogic = this.a((ChunkPosition)this.g.get(j));
            if (raillogic != null) {
               raillogic.a();
               if (raillogic.c(this)) {
                  raillogic.d(this);
               }
            }
         }
      }
   }

   static int a(RailLogic par0RailLogic) {
      return par0RailLogic.b();
   }
}
