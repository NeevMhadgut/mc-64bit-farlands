import java.util.ArrayList;
import java.util.List;

public class EntityAIMoveThroughVillage extends rc {
   private EntityCreature a;
   private float b;
   private PathEntity c;
   private VillageDoorInfo d;
   private boolean e;
   private List f = new ArrayList();

   public EntityAIMoveThroughVillage(EntityCreature par1EntityCreature, float par2, boolean par3) {
      this.a = par1EntityCreature;
      this.b = par2;
      this.e = par3;
      this.a(1);
   }

   public boolean a() {
      this.h();
      if (this.e && this.a.k.m()) {
         return false;
      }

      Village village = this.a.k.A.findNearestVillage(MathHelper.d(this.a.o), MathHelper.c(this.a.p), MathHelper.d(this.a.q), 0);
      if (village == null) {
         return false;
      }

      this.d = this.a(village);
      if (this.d == null) {
         return false;
      }

      boolean flag = this.a.aM().b();
      this.a.aM().b(false);
      this.c = this.a.aM().a(this.d.a, this.d.b, this.d.c);
      this.a.aM().b(flag);
      if (this.c != null) {
         return true;
      }

      bo vec3d = RandomPositionGenerator.a(this.a, 10, 7, bo.b(this.d.a, this.d.b, this.d.c));
      if (vec3d == null) {
         return false;
      }

      this.a.aM().b(false);
      this.c = this.a.aM().a(vec3d.a, vec3d.b, vec3d.c);
      this.a.aM().b(flag);
      return this.c != null;
   }

   public boolean b() {
      if (this.a.aM().e()) {
         return false;
      }

      float f = this.a.I + 4.0F;
      return this.a.f(this.d.a, this.d.b, this.d.c) > f * f;
   }

   public void c() {
      this.a.aM().a(this.c, this.b);
   }

   public void d() {
      if (this.a.aM().e() || this.a.f(this.d.a, this.d.b, this.d.c) < 16.0) {
         this.f.add(this.d);
      }
   }

   private VillageDoorInfo a(Village par1Village) {
      VillageDoorInfo villagedoorinfo = null;
      int i = Integer.MAX_VALUE;

      for (VillageDoorInfo villagedoorinfo1 : par1Village.f()) {
         int j = villagedoorinfo1.getDistanceSquared(MathHelper.d(this.a.o), MathHelper.c(this.a.p), MathHelper.d(this.a.q));
         if (j < i && !this.a(villagedoorinfo1)) {
            villagedoorinfo = villagedoorinfo1;
            i = j;
         }
      }

      return villagedoorinfo;
   }

   private boolean a(VillageDoorInfo par1VillageDoorInfo) {
      for (VillageDoorInfo villagedoorinfo : this.f) {
         if (par1VillageDoorInfo.a == villagedoorinfo.a && par1VillageDoorInfo.b == villagedoorinfo.b && par1VillageDoorInfo.c == villagedoorinfo.c) {
            return true;
         }
      }

      return false;
   }

   private void h() {
      if (this.f.size() > 15) {
         this.f.remove(0);
      }
   }
}
