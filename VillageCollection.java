import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VillageCollection {
   private World a;
   private final List b = new ArrayList();
   private final List c = new ArrayList();
   private final List d = new ArrayList();
   private int e = 0;

   public VillageCollection(World par1World) {
      this.a = par1World;
   }

   public void addVillagerPosition(long par1, int par2, long par3) {
      if (this.b.size() <= 64) {
         if (!this.isVillagerPositionPresent(par1, par2, par3)) {
            this.b.add(new ChunkCoordinates(par1, par2, par3));
         }
      }
   }

   public void a() {
      this.e++;

      for (Village village : this.d) {
         village.a(this.e);
      }

      this.c();
      this.d();
      this.e();
   }

   private void c() {
      Iterator iterator = this.d.iterator();

      while (iterator.hasNext()) {
         Village village = (Village)iterator.next();
         if (village.g()) {
            iterator.remove();
         }
      }
   }

   public List b() {
      return this.d;
   }

   public Village findNearestVillage(long par1, int par2, long par3, int par4) {
      Village village = null;
      double f = 3.402823E38F;

      for (Village village1 : this.d) {
         double f1 = village1.a().getDistanceSquared(par1, par2, par3);
         if (f1 < f) {
            int i = par4 + village1.b();
            if (f1 <= i * i) {
               village = village1;
               f = f1;
            }
         }
      }

      return village;
   }

   private void d() {
      if (!this.b.isEmpty()) {
         this.a((ChunkCoordinates)this.b.remove(0));
      }
   }

   private void e() {
      for (int i = 0; i < this.c.size(); i++) {
         VillageDoorInfo villagedoorinfo = (VillageDoorInfo)this.c.get(i);
         boolean flag = false;

         for (Village village1 : this.d) {
            long j = (long)village1.a().getEuclideanDistanceTo(villagedoorinfo.a, villagedoorinfo.b, villagedoorinfo.c);
            if (j <= 32 + village1.b()) {
               village1.a(villagedoorinfo);
               flag = true;
               break;
            }
         }

         if (!flag) {
            Village village = new Village(this.a);
            village.a(villagedoorinfo);
            this.d.add(village);
         }
      }

      this.c.clear();
   }

   private void a(ChunkCoordinates par1ChunkCoordinates) {
      byte byte0 = 16;
      byte byte1 = 4;
      byte byte2 = 16;

      for (long i = par1ChunkCoordinates.a - byte0; i < par1ChunkCoordinates.a + byte0; i++) {
         for (int j = par1ChunkCoordinates.b - byte1; j < par1ChunkCoordinates.b + byte1; j++) {
            for (long k = par1ChunkCoordinates.c - byte2; k < par1ChunkCoordinates.c + byte2; k++) {
               if (this.isWoodenDoorAt(i, j, k)) {
                  VillageDoorInfo villagedoorinfo = this.getVillageDoorAt(i, j, k);
                  if (villagedoorinfo == null) {
                     this.addDoorToNewListIfAppropriate(i, j, k);
                  } else {
                     villagedoorinfo.f = this.e;
                  }
               }
            }
         }
      }
   }

   private VillageDoorInfo getVillageDoorAt(long par1, int par2, long par3) {
      for (VillageDoorInfo villagedoorinfo : this.c) {
         if (villagedoorinfo.a == par1 && villagedoorinfo.c == par3 && Math.abs(villagedoorinfo.b - par2) <= 1) {
            return villagedoorinfo;
         }
      }

      for (Village village : this.d) {
         VillageDoorInfo villagedoorinfo1 = village.getVillageDoorAt(par1, par2, par3);
         if (villagedoorinfo1 != null) {
            return villagedoorinfo1;
         }
      }

      return null;
   }

   private void addDoorToNewListIfAppropriate(long par1, int par2, long par3) {
      int i = ((BlockDoor)Block.aE).getDoorOrientation(this.a, par1, par2, par3);
      if (i != 0 && i != 2) {
         int k = 0;

         for (int j1 = -5; j1 < 0; j1++) {
            if (this.a.canBlockSeeTheSky(par1, par2, par3 + j1)) {
               k--;
            }
         }

         for (int k1 = 1; k1 <= 5; k1++) {
            if (this.a.canBlockSeeTheSky(par1, par2, par3 + k1)) {
               k++;
            }
         }

         if (k != 0) {
            this.c.add(new VillageDoorInfo(par1, par2, par3, 0, k <= 0 ? 2 : -2, this.e));
         }
      } else {
         int j = 0;

         for (int l = -5; l < 0; l++) {
            if (this.a.canBlockSeeTheSky(par1 + l, par2, par3)) {
               j--;
            }
         }

         for (int i1 = 1; i1 <= 5; i1++) {
            if (this.a.canBlockSeeTheSky(par1 + i1, par2, par3)) {
               j++;
            }
         }

         if (j != 0) {
            this.c.add(new VillageDoorInfo(par1, par2, par3, j <= 0 ? 2 : -2, 0, this.e));
         }
      }
   }

   private boolean isVillagerPositionPresent(long par1, int par2, long par3) {
      for (ChunkCoordinates chunkcoordinates : this.b) {
         if (chunkcoordinates.a == par1 && chunkcoordinates.b == par2 && chunkcoordinates.c == par3) {
            return true;
         }
      }

      return false;
   }

   private boolean isWoodenDoorAt(long par1, int par2, long par3) {
      int i = this.a.getBlockId(par1, par2, par3);
      return i == Block.aE.bO;
   }
}
