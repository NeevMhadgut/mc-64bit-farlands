import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Village {
   private final World a;
   private final List b = new ArrayList();
   private final ChunkCoordinates c = new ChunkCoordinates(0L, 0, 0L);
   private final ChunkCoordinates d = new ChunkCoordinates(0L, 0, 0L);
   private int e = 0;
   private int f = 0;
   private int g = 0;
   private int h = 0;
   private List i = new ArrayList();
   private int j = 0;

   public Village(World par1World) {
      this.a = par1World;
   }

   public void a(int par1) {
      this.g = par1;
      this.k();
      this.j();
      if (par1 % 20 == 0) {
         this.i();
      }

      if (par1 % 30 == 0) {
         this.h();
      }

      int i = this.h / 16;
      if (this.j < i && this.b.size() > 20 && this.a.r.nextInt(7000) == 0) {
         bo vec3d = this.tryGetIronGolemSpawningLocation(MathHelper.d(this.d.a), MathHelper.d(this.d.b), MathHelper.d(this.d.c), 2L, 4, 2L);
         if (vec3d != null) {
            EntityIronGolem entityirongolem = new EntityIronGolem(this.a);
            entityirongolem.d(vec3d.a, vec3d.b, vec3d.c);
            this.a.a(entityirongolem);
            this.j++;
         }
      }
   }

   private bo tryGetIronGolemSpawningLocation(long par1, int par2, long par3, long par4, int par5, long par6) {
      for (int i = 0; i < 10; i++) {
         long j = par1 + this.a.r.nextInt(16) - 8L;
         int k = par2 + this.a.r.nextInt(6) - 3;
         long l = par3 + this.a.r.nextInt(16) - 8L;
         if (this.isInRange(j, k, l) && this.isValidIronGolemSpawningLocation(j, k, l, par4, par5, par6)) {
            return bo.b(j, k, l);
         }
      }

      return null;
   }

   private boolean isValidIronGolemSpawningLocation(long par1, int par2, long par3, long par4, int par5, long par6) {
      if (!this.a.isBlockNormalCube(par1, par2 - 1, par3)) {
         return false;
      }

      long i = par1 - par4 / 2L;
      long j = par3 - par6 / 2L;

      for (long k = i; k < i + par4; k++) {
         for (int l = par2; l < par2 + par5; l++) {
            for (long i1 = j; i1 < j + par6; i1++) {
               if (this.a.isBlockNormalCube(k, l, i1)) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   private void h() {
      List list = this.a.a(EntityIronGolem.class, AxisAlignedBB.b(this.d.a - this.e, this.d.b - 4, this.d.c - this.e, this.d.a + this.e, this.d.b + 4, this.d.c + this.e));
      this.j = list.size();
   }

   private void i() {
      List list = this.a.a(EntityVillager.class, AxisAlignedBB.b(this.d.a - this.e, this.d.b - 4, this.d.c - this.e, this.d.a + this.e, this.d.b + 4, this.d.c + this.e));
      this.h = list.size();
   }

   public ChunkCoordinates a() {
      return this.d;
   }

   public int b() {
      return this.e;
   }

   public int c() {
      return this.b.size();
   }

   public int d() {
      return this.g - this.f;
   }

   public int e() {
      return this.h;
   }

   public boolean isInRange(long par1, int par2, long par3) {
      return this.d.getDistanceSquared(par1, par2, par3) < this.e * this.e;
   }

   public List f() {
      return this.b;
   }

   public VillageDoorInfo findNearestDoor(long par1, int par2, long par3) {
      VillageDoorInfo villagedoorinfo = null;
      int i = Integer.MAX_VALUE;

      for (VillageDoorInfo villagedoorinfo1 : this.b) {
         int j = villagedoorinfo1.getDistanceSquared(par1, par2, par3);
         if (j < i) {
            villagedoorinfo = villagedoorinfo1;
            i = j;
         }
      }

      return villagedoorinfo;
   }

   public VillageDoorInfo findNearestDoorUnrestricted(long par1, int par2, long par3) {
      VillageDoorInfo villagedoorinfo = null;
      int i = Integer.MAX_VALUE;

      for (VillageDoorInfo villagedoorinfo1 : this.b) {
         int j = villagedoorinfo1.getDistanceSquared(par1, par2, par3);
         if (j > 256) {
            j *= 1000;
         } else {
            j = villagedoorinfo1.f();
         }

         if (j < i) {
            villagedoorinfo = villagedoorinfo1;
            i = j;
         }
      }

      return villagedoorinfo;
   }

   public VillageDoorInfo getVillageDoorAt(long par1, int par2, long par3) {
      if (this.d.getDistanceSquared(par1, par2, par3) > this.e * this.e) {
         return null;
      }

      for (VillageDoorInfo villagedoorinfo : this.b) {
         if (villagedoorinfo.a == par1 && villagedoorinfo.c == par3 && Math.abs(villagedoorinfo.b - par2) <= 1) {
            return villagedoorinfo;
         }
      }

      return null;
   }

   public void a(VillageDoorInfo par1VillageDoorInfo) {
      this.b.add(par1VillageDoorInfo);
      this.c.a = this.c.a + par1VillageDoorInfo.a;
      this.c.b = this.c.b + par1VillageDoorInfo.b;
      this.c.c = this.c.c + par1VillageDoorInfo.c;
      this.l();
      this.f = par1VillageDoorInfo.f;
   }

   public boolean g() {
      return this.b.isEmpty();
   }

   public void a(EntityLiving par1EntityLiving) {
      for (afr villageagressor : this.i) {
         if (villageagressor.a == par1EntityLiving) {
            villageagressor.b = this.g;
            return;
         }
      }

      this.i.add(new afr(this, par1EntityLiving, this.g));
   }

   public EntityLiving b(EntityLiving par1EntityLiving) {
      double d = Double.MAX_VALUE;
      afr villageagressor = null;

      for (int i = 0; i < this.i.size(); i++) {
         afr villageagressor1 = (afr)this.i.get(i);
         double d1 = villageagressor1.a.f(par1EntityLiving);
         if (d1 <= d) {
            villageagressor = villageagressor1;
            d = d1;
         }
      }

      return villageagressor == null ? null : villageagressor.a;
   }

   private void j() {
      Iterator iterator = this.i.iterator();

      while (iterator.hasNext()) {
         afr villageagressor = (afr)iterator.next();
         if (!villageagressor.a.M() || Math.abs(this.g - villageagressor.b) > 300) {
            iterator.remove();
         }
      }
   }

   private void k() {
      boolean flag = false;
      boolean flag1 = this.a.r.nextInt(50) == 0;
      Iterator iterator = this.b.iterator();

      while (iterator.hasNext()) {
         VillageDoorInfo villagedoorinfo = (VillageDoorInfo)iterator.next();
         if (flag1) {
            villagedoorinfo.d();
         }

         if (!this.isBlockDoor(villagedoorinfo.a, villagedoorinfo.b, villagedoorinfo.c) || Math.abs(this.g - villagedoorinfo.f) > 1200) {
            this.c.a = this.c.a - villagedoorinfo.a;
            this.c.b = this.c.b - villagedoorinfo.b;
            this.c.c = this.c.c - villagedoorinfo.c;
            flag = true;
            villagedoorinfo.g = true;
            iterator.remove();
         }
      }

      if (flag) {
         this.l();
      }
   }

   private boolean isBlockDoor(long par1, int par2, long par3) {
      int i = this.a.getBlockId(par1, par2, par3);
      return i <= 0 ? false : i == Block.aE.bO;
   }

   private void l() {
      int i = this.b.size();
      if (i == 0) {
         this.d.set(0L, 0, 0L);
         this.e = 0;
      } else {
         this.d.set(this.c.a / i, this.c.b / i, this.c.c / i);
         int j = 0;

         for (VillageDoorInfo villagedoorinfo : this.b) {
            j = Math.max(villagedoorinfo.getDistanceSquared(this.d.a, this.d.b, this.d.c), j);
         }

         this.e = Math.max(32, (int)Math.sqrt(j) + 1);
      }
   }
}
